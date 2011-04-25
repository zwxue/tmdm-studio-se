package com.amalto.workbench.detailtabs.sections;

import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xsd.XSDComponent;

import com.amalto.workbench.detailtabs.sections.model.ISubmittable;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.extra.DefaultValueAnnoInfo;
import com.amalto.workbench.utils.XSDAnnotationsStructure;
import com.amalto.workbench.widgets.SchematronExpressBuilder;

public abstract class AbstractValidateRuleExpressionSection extends
		XSDComponentSection {

	private SchematronExpressBuilder builder;
	private StyledText textWidget;

	@Override
	protected void initUIContents(XSDComponent editedObj) {
		super.initUIContents(editedObj);
		String defaultValue = getInitRule();
		removeUIListener();
		updateValue2UI(defaultValue);
		if (defaultValue != null) {
			if (defaultValue.length() >= caretOffset) {
				textWidget.setCaretOffset(caretOffset);
			} else {
				textWidget.setCaretOffset(defaultValue.length());
			}
		}
		addUIListener();
	}

	private int caretOffset;
	private ITextListener textListener;

	protected abstract String getInitRule();

	@Override
	protected void createControlsInSection(Composite compSectionClient) {
		builder = new SchematronExpressBuilder(compSectionClient, "", null,
				false);

		textWidget = builder.getTextWidget();
		textWidget.setBackground(compSectionClient.getShell().getDisplay()
				.getSystemColor(SWT.COLOR_INFO_BACKGROUND));

		textListener = new ITextListener() {

			@Override
			public void textChanged(TextEvent event) {
				caretOffset = textWidget.getCaretOffset();
				AbstractValidateRuleExpressionSection.this.autoCommit();
			}
		};

	}

	private void addUIListener() {
		builder.getSourceViewer().addTextListener(textListener);
	}

	private void removeUIListener() {
		builder.getSourceViewer().removeTextListener(textListener);
	}

	private void updateValue2UI(String defaultValue) {
		textWidget.setText(defaultValue != null ? defaultValue : "");
	}

	protected String getDefaultValueFromUI() {
		return builder.getText();
	}

}
