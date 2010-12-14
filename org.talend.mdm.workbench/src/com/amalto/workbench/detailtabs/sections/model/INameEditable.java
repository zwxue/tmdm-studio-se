package com.amalto.workbench.detailtabs.sections.model;

public interface INameEditable {

    public String getName();

    public void setName(String name);

    public String validNewName(String newName);
}
