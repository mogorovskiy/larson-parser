package org.mogorovskiy.helper;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;

public class JsoupHelper {

    public static List<String> toStringList(Elements elements) {
        List<String> result = new ArrayList<>();
        for (Element element : elements) {
            result.add(element.text());
        }
        return result;
    }
}
