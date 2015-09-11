package com.amalto.workbench.widgets.composites;

import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;

public class ElementFKInfotPartitionScanner extends RuleBasedPartitionScanner {

    public static final String COMMON_STRING = "common_string"; //$NON-NLS-1$

    public ElementFKInfotPartitionScanner() {
        IPredicateRule[] rules = new IPredicateRule[2];

        IToken string = new Token(COMMON_STRING);
        rules[0] = new SingleLineRule("\"", "\"", string, '\\'); //$NON-NLS-1$ //$NON-NLS-2$
        rules[1] = new SingleLineRule("\'", "\'", string, '\\'); //$NON-NLS-1$ //$NON-NLS-2$

        setPredicateRules(rules);
    }

}