/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Container Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getContainerType()
 * @model
 * @generated
 */
public enum ContainerType implements Enumerator {
    /**
     * The '<em><b>CATEGORY</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CATEGORY_VALUE
     * @generated
     * @ordered
     */
    CATEGORY(0, "CATEGORY", "CATEGORY"),

    /**
     * The '<em><b>SYSTEM FOLDER</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SYSTEM_FOLDER_VALUE
     * @generated
     * @ordered
     */
    SYSTEM_FOLDER(2, "SYSTEM_FOLDER", "SYSTEM_FOLDER"),

    /**
     * The '<em><b>FOLDER</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #FOLDER_VALUE
     * @generated
     * @ordered
     */
    FOLDER(1, "FOLDER", "FOLDER");

    /**
     * The '<em><b>CATEGORY</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>CATEGORY</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #CATEGORY
     * @model
     * @generated
     * @ordered
     */
    public static final int CATEGORY_VALUE = 0;

    /**
     * The '<em><b>SYSTEM FOLDER</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>SYSTEM FOLDER</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #SYSTEM_FOLDER
     * @model
     * @generated
     * @ordered
     */
    public static final int SYSTEM_FOLDER_VALUE = 2;

    /**
     * The '<em><b>FOLDER</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>FOLDER</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #FOLDER
     * @model
     * @generated
     * @ordered
     */
    public static final int FOLDER_VALUE = 1;

    /**
     * An array of all the '<em><b>Container Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final ContainerType[] VALUES_ARRAY =
        new ContainerType[] {
            CATEGORY,
            SYSTEM_FOLDER,
            FOLDER,
        };

    /**
     * A public read-only list of all the '<em><b>Container Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<ContainerType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Container Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ContainerType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ContainerType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Container Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ContainerType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ContainerType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Container Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ContainerType get(int value) {
        switch (value) {
            case CATEGORY_VALUE: return CATEGORY;
            case SYSTEM_FOLDER_VALUE: return SYSTEM_FOLDER;
            case FOLDER_VALUE: return FOLDER;
        }
        return null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final int value;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final String name;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final String literal;

    /**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private ContainerType(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getValue() {
      return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
      return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLiteral() {
      return literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string representation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        return literal;
    }
    
} //ContainerType
