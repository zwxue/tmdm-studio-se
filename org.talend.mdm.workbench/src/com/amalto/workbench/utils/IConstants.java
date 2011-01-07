package com.amalto.workbench.utils;

public interface IConstants {

    /* Conditions operator */
    static final String[] COMPOSITE_VIEW_CONDITION_OPERATORS = { "Contains", "Join With", "Contains Text Of", "Starts With",
            "Strict Contains", "=", "!=", ">", ">=", "<", "<=" };

    static final String[] VIEW_CONDITION_OPERATORS = { "Contains", "Contains Text Of", "Starts With", "Strict Contains", "=",
            "!=", ">", ">=", "<", "<=" };

    static final String[] ROUTE_CONDITION_OPERATORS = { "Contains", "Matches", "Starts With", "Is Null", "Is Not Null", "=",
            "!=", ">", ">=", "<", "<=" };

    static final String[] SCHEMATRON_TYPES = { "assert", "report" };

    /* Operate Type */
    static final String[] OPERATE_TYPES = { "UPDATE", "CREATE", "DELETE" };

    static final String[] PREDICATES = { "", "Or", "And", "Strict And", "Exactly", "Not" };

    /**
     * The default universe name
     */
    static final String HEAD = "HEAD";

    static final String TALEND = "Talend MDM Studio";

    // static final String TALEND_MDM="Talend MDM";
    /**
     * Used for Update Report
     */
    public final static String SOURCE_GENERICUI = "genericUI";

    public final static String SOURCE_ADMINWORKBENCH = "adminWorkbench";

    public final static String SOURCE_DATASYNCHRONIZATION = "dataSynchronization";

    public final static String OPERATIONTYPE_CREATE = "CREATE";

    public final static String OPERATIONTYPE_UPDATEE = "UPDATE";

    public final static String OPERATIONTYPE_DELETE = "DELETE";

    // public final static String OPERATIONTYPE_SYNCHRONIZE="SYNCHRONIZE";

    /**
     * Used for exist admin user/passwd
     */
    public final static String EXIST_ADMIN = "admin";

    public final static String EXIST_ADMIN_PASSWD = "1bc29b36f623ba82aaf6724fd3b16718";

    public final static String EXIST_PORT = "8080";

    public final static String DEFAULT_NAME_SPACE = "http://www.w3.org/2001/XMLSchema";

    /**
     * Used for simple type facet
     */

    public static final String SIMPLETYPE_FACETNAME_PATTERN = "pattern";

    public static final String SIMPLETYPE_FACETNAME_ENUM = "enumeration";

    public static final String SIMPLETYPE_FACETNAME_LENGTH = "length";

    public static final String SIMPLETYPE_FACETNAME_MINLENGTH = "minLength";

    public static final String SIMPLETYPE_FACETNAME_MAXLENGTH = "maxLength";

    public static final String SIMPLETYPE_FACETNAME_TOTALDIGITS = "totalDigits";

    public static final String SIMPLETYPE_FACETNAME_FRACTIONDIGITS = "fractionDigits";

    public static final String SIMPLETYPE_FACETNAME_MAXINCLUSIVE = "maxInclusive";

    public static final String SIMPLETYPE_FACETNAME_MAXEXCLUSIVE = "maxExclusive";

    public static final String SIMPLETYPE_FACETNAME_MININCLUSIVE = "minInclusive";

    public static final String SIMPLETYPE_FACETNAME_MINEXCLUSIVE = "minExclusive";

    public static final String SIMPLETYPE_FACETNAME_WHITESPACE = "whiteSpace";
}
