package com.amalto.workbench.widgets;

import java.util.List;

import com.amalto.workbench.models.Line;

public interface ITableModifyListener {
	public void handleEvent(List<Line> input);
}
