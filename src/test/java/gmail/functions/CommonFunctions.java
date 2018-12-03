package gmail.functions;

import framework.elements.Label;

import java.util.List;

public class CommonFunctions {

    public List<String> getListOfTexts(Label text) {
        List<String> texts = text.getListOfContent();
        for (int i = 0; i < texts.size(); i++) {
            String[] split;
            split = texts.get(i).split("\\n");
            texts.set(i, split[1]);
        }
        return texts;
    }

    public List<String> getListOfDates(Label date) {
        List<String> dates = date.getListOfAttribute("aria-label");
        for (int j = 0; j < dates.size(); j++) {
            String[] split2;
            split2 = dates.get(j).split(", ", 2);
            dates.set(j, split2[1]);
        }
        return dates;
    }

}
