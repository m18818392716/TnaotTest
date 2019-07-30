package com.tnaot.utils.AppiumUtils;

public class SwipeUtils {

    // find element by name
    public static final String NAME = "NAME";

    // find element by id
    public static final String ID = "ID";

    // find element by classname
    public static final String CLASSNAME = "CLASSNAME";

    // find element by AccessibilityId
    public static final String ACCESSIBILITYID = "AccessibilityId";

    public static final String INDEX = "INDEX";

    public static final String INSTENCE = "INSTENCE";

    // name,id,AccessibilityId method
    public String scrollTo(String content, String type) {
        String uiautomatorStr = null;

        if (type == "NAME") {
            uiautomatorStr =
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + content
                            + "\"))";
        } else if (type == "ID") {
            uiautomatorStr =
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceId(\""
                            + content + "\"))";
        } else if (type == "AccessibilityId") {
            uiautomatorStr =
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(\""
                            + content + "\"))";
        }
        return uiautomatorStr;
    }

    // className method
    public String scrollTo(String content, String className, String type, int number) {
        String uiautomatorStr = null;

        // find element by classname && index
        if (className == "CLASSNAME" && type == "INDEX") {
            uiautomatorStr = "new UiScrollable(new UiSelector().scrollable(true).index(" + number
                    + ")).getChildByText(new UiSelector().className(\"" + content + "\")";
        }
        // find element by classname && instance
        else if (className == "CLASSNAME" && type == "INSTENCE") {
            uiautomatorStr = "new UiScrollable(new UiSelector().scrollable(true).instance(" + number
                    + ")).getChildByText(new UiSelector().className(\"" + content + "\")";
        }
        return uiautomatorStr;
    }
    // 嵌入的语句里，我们用到的是UiScrollable对象的scrollIntoView方法，scrollIntoView 是一个特例，会返回滚动到指定控件的元素。
    // scrollIntoView 对任何的 UiSelector 都可以执行滚动操作
}
