package com.amalto.workbench.editors.xmleditor;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

public class XMLPartitionScanner extends RuleBasedPartitionScanner {
	public final static String XML_COMMENT = "__xml_comment";
	public final static String XML_TAG = "__xml_tag";

	public XMLPartitionScanner() {

		IToken xmlComment = new Token(XML_COMMENT);
		IToken tag = new Token(XML_TAG);

		IPredicateRule[] rules = new IPredicateRule[2];

		rules[0] = new MultiLineRule("<!--", "-->", xmlComment);
		rules[1] = new TagRule(tag);
//		WhitespaceRule whiteRule = new WhitespaceRule(new WhitespaceDetector());
		setPredicateRules(rules);
	}
}

 class FormatRule implements IRule {
	 
    private final IToken token;
 
    public FormatRule(IToken token) {
        this.token = token;
    }
 
    public IToken evaluate(ICharacterScanner scanner) {
        int c = scanner.read();
        if (c == '%') {
            do {
                c = scanner.read();
            } while (c != ICharacterScanner.EOF
                    && (Character.isLetterOrDigit((char) c) || c == '-' || c == '.'));
            scanner.unread();
 
            return token;
        }
        scanner.unread();
        return Token.UNDEFINED;
    }
 
}
