package com.gaozhd.studydemo.androidbase.rxjava;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;
import com.gaozhd.studydemo.androidbase.greendao.biz.DBUserBiz;
import com.gaozhd.studydemo.androidbase.greendao.entry.DBUser;
import com.gaozhd.studydemo.utils.LogUtil;
import com.gaozhd.studydemo.utils.ThreedUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * RxJava 的使用
 * 1.创建观察者
 * 2.创建被观察者
 * 3.绑定
 */
public class RxJavaActivity extends BaseActivity {

    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rxjava1);
        ButterKnife.bind(this);
    }

    private void db() {

        final DBUserBiz dbUserBiz = new DBUserBiz(this);
        //1.创建观察者
        /*
         * 除了 Observer 接口之外，RxJava 还内置了一个实现了 Observer 的抽象类：Subscriber。 Subscriber 对 Observer 接口进行了一些扩展，但他们的基本使用方式是完全一样的：
         * 不仅基本使用方式一样，实质上，在 RxJava 的 subscribe 过程中，Observer 也总是会先被转换成一个 Subscriber 再使用。
         * 所以如果你只想使用基本功能，选择 Observer 和 Subscriber 是完全一样的。它们的区别对于使用者来说主要有两点：
         * 1.onStart(): 这是 Subscriber 增加的方法。它会在 subscribe 刚开始，而事件还未发送之前被调用，可以用于做一些准备工作，
         *            例如数据的清零或重置。这是一个可选方法，默认情况下它的实现为空。
         *            需要注意的是，如果对准备工作的线程有要求（例如弹出一个显示进度的对话框，这必须在主线程执行），
         *            onStart() 就不适用了，因为它总是在 subscribe 所发生的线程被调用，而不能指定线程。
         *            要在指定的线程来做准备工作，可以使用 doOnSubscribe() 方法，具体可以在后面的文中看到。
         * 2.unsubscribe(): 这是 Subscriber 所实现的另一个接口 Subscription 的方法，用于取消订阅。
         *             在这个方法被调用后，Subscriber 将不再接收事件。一般在这个方法调用前，可以使用 isUnsubscribed() 先判断一下状态。
         *             unsubscribe() 这个方法很重要，因为在 subscribe() 之后， Observable 会持有 Subscriber 的引用，这个引用如果不能及时被释放，
         *             将有内存泄露的风险。所以最好保持一个原则：要在不再使用的时候尽快在合适的地方（例如 onPause() onStop() 等方法中）
         *             调用 unsubscribe() 来解除引用关系，以避免内存泄露的发生。
         */
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                LogUtil.log("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                LogUtil.log("onError" + e.getMessage());
            }

            @Override
            public void onNext(String s) {
                LogUtil.log("onNext：" + s);
            }
        };

        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                LogUtil.log("onCompleted");
                ThreedUtil.logCurrentThreed();
            }

            @Override
            public void onError(Throwable e) {
                LogUtil.log("onError:" + e.getMessage());
                ThreedUtil.logCurrentThreed();
            }

            @Override
            public void onNext(String s) {
                LogUtil.log("onNext：" + s);
//                tv.setText(s);
                ThreedUtil.logCurrentThreed();
            }

            @Override
            public void onStart() {
                super.onStart();
                LogUtil.log("onStart");
                ThreedUtil.logCurrentThreed();
            }
        };

        //2.创建被观察者
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

                LogUtil.log("call");
                ThreedUtil.logCurrentThreed();

                DBUser dbUser = dbUserBiz.getUserByID("002");
                subscriber.onNext(dbUser == null ? " null " : dbUser.getName());
                ThreedUtil.logCurrentThreed();

                dbUser = dbUserBiz.getUserByID("002");
                subscriber.onNext(dbUser == null ? " null " : dbUser.getName());
                ThreedUtil.logCurrentThreed();

                dbUser = dbUserBiz.getUserByID("003");
                subscriber.onNext(dbUser == null ? " null " : dbUser.getName());
                ThreedUtil.logCurrentThreed();

                dbUser = dbUserBiz.getUserByID("004");
                subscriber.onNext(dbUser == null ? " null " : dbUser.getName());
                ThreedUtil.logCurrentThreed();

                subscriber.onCompleted();
            }
        }).map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s + ":kkkk:";
            }
        });

        //3.被观察者绑定观察者
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);

        /**
         *下面的写法无效，设置线程和绑定需要写在一起.
         * 每次设置线程后都会重新生成一个observable。与设置前并不是同一个
         */
        //observable.subscribeOn(Schedulers.io())；
        //observable.observeOn(AndroidSchedulers.mainThread());
        //observable.subscribe(subscriber);

        /**
         * 如果想分开写时候的写法
         */
        //Observable<String> observable1 = observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        //observable1.subscribe(subscriber);
    }

    private void net() {

        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                LogUtil.log("------->call线程:" + Thread.currentThread().getName());
                ThreedUtil.logCurrentThreed();
                subscriber.onNext("sss");
            }
        });
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                LogUtil.log("------->onNext线程:" + Thread.currentThread().getName());
                ThreedUtil.logCurrentThreed();
            }
        });
    }

    private void net1() {
        RxManager.getInstance().addSubscribe("k", new RxObservable.RxCall<String>() {
            @Override
            public String call() {
                return "kkk";
            }
        }, new RxSubscriber.RxNext<String>() {
            @Override
            public void doNext(String data) {
                LogUtil.log(data);
            }
        });
    }

    private void setText(String text) {
        tv.setText(text);
    }

    @OnClick({R.id.btn_db, R.id.btn_net})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_db:
                setText("loading...");
                db();
                break;
            case R.id.btn_net:
                setText("loading...");
                net1();
                break;
        }
    }
}
