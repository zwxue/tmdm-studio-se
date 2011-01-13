package com.amalto.workbench.widgets.celleditor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.amalto.workbench.detailtabs.sections.model.annotationinfo.langinfo.LanguageInfo;
import com.amalto.workbench.dialogs.AnnotationLangInfoDialog;
import com.amalto.workbench.utils.Util;

public class LangInfoCellEditor extends EditableDialogCellEditor {

    private static final String REGEXP_METACHARACTERS = "\\[([\\w]+)[\\s]*:[\\s]*([^]]*)\\]";

    public LangInfoCellEditor(Composite parent) {
        super(parent);
    }

    @Override
    protected Object openDialogBox(Control cellEditorWindow) {
        AnnotationLangInfoDialog dialog = new AnnotationLangInfoDialog(cellEditorWindow.getShell(), parseInput());

        if (dialog.open() != Window.OK)
            return null;

        return translateLangInfo(dialog.getLangInfos());
    }

    private String translateLangInfo(LanguageInfo[] langInfos) {

        String result = "";

        for (LanguageInfo eachLangInfo : langInfos)
            result += "[" + eachLangInfo.getLanguageISOCode().toUpperCase() + ":" + eachLangInfo.getLabel() + "]";

        return result;
    }

    private LanguageInfo[] parseInput() {

        if (getValue() == null || !(getValue() instanceof String))
            return new LanguageInfo[0];

        List<LanguageInfo> results = new ArrayList<LanguageInfo>();
        String expression = (String) getValue();

        boolean find = false;
        Matcher match = Pattern.compile(REGEXP_METACHARACTERS).matcher(expression);
        while (match.find()) {
            find = true;
            String countryISOCode = match.group(1).trim().toLowerCase();
            String desc = match.group(2).trim();
            String country = Util.iso2lang.get(countryISOCode);
            if (country != null)
                results.add(new LanguageInfo(country, countryISOCode, desc));
        }

        if (!find && !expression.equals(""))
            results.add(new LanguageInfo("English", "en", expression));

        return results.toArray(new LanguageInfo[0]);
    }
}
