package com.gaozhd.studydemo.javabase.s_enum;

/**
 * @author Gao ZhiDong <gaozhidong@tiantanhehe.com>
 * @ClassName: ${type_name}
 * @Description: ${todo}
 * @date ${date} ${time}
 * <p/>
 * ${tags}
 */
public enum SColor {
    Red("RED", "1"), Blue("BLUE", "2"), Green("GREEN", "3");
    private String name;
    private String index;

    public static final String RED = "1";

    private SColor(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(String index) {
        for (SColor c : SColor.values()) {
            if (c.getIndex().equals(index))
                return c.getName();

        }
        return "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
