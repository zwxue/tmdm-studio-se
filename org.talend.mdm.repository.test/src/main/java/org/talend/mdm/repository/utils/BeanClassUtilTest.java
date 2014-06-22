package org.talend.mdm.repository.utils;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.powermock.reflect.Whitebox;

import com.amalto.workbench.webservices.WSMenu;

// @RunWith(PowerMockRunner.class)
@PrepareForTest({ BeanClassUtil.class })
public class BeanClassUtilTest {

    @Rule
    public PowerMockRule powerMockRule = new PowerMockRule();

    private BeanClassUtil bClassUtil;

    @Before
    public void setUp() throws Exception {
        Bean2EObjUtil util = Bean2EObjUtil.getInstance();
        bClassUtil = new BeanClassUtil(util);
    }

    @After
    public void tearDown() throws Exception {
        bClassUtil = null;
    }

    @Test
    public void testRefactorClassStructure() throws Exception {
        Class<BaseTypeClass> cls = BaseTypeClass.class;
        verifyBaseTypeClass(cls);

        Class<ObjectClass> oClass = ObjectClass.class;
        verifyObjectTypeClass(oClass);
    }

    private void verifyObjectTypeClass(Class<ObjectClass> cls) throws Exception {
        tearDown();
        setUp();

        bClassUtil.refactorClassStructure(cls);

        Map<Object, Method[]> fieldMap = bClassUtil.findFieldMap(cls);
        assertNotNull(fieldMap);
        assertTrue(fieldMap.size() > 0);

        // verify the field and method number
        assertEquals(cls.getFields().length, fieldMap.keySet().size());
        assertEquals(cls.getDeclaredMethods().length, fieldMap.values().size() * 2);

        // verify the field
        List<Field> flist = Arrays.asList(cls.getFields());
        if (!(flist.containsAll(fieldMap.keySet()) && fieldMap.keySet().containsAll(flist))) {
            fail("the field is inconsistent");
        }

        // verify the method
        List<Method> mapList = new ArrayList<Method>();
        for (Iterator<Method[]> it = fieldMap.values().iterator(); it.hasNext();) {
            mapList.addAll(Arrays.asList(it.next()));
        }
        List<Method> asList = Arrays.asList(cls.getDeclaredMethods());
        if (!(asList.containsAll(mapList) && mapList.containsAll(asList))) {
            fail("the method is inconsistent");
        }
    }

    private void verifyBaseTypeClass(Class<BaseTypeClass> cls) {
        bClassUtil.refactorClassStructure(cls);

        Map<Object, Method[]> fieldMap = bClassUtil.findFieldMap(cls);
        assertNotNull(fieldMap);
        assertTrue(fieldMap.size() > 0);

        // verify the field and method number
        assertEquals(cls.getFields().length, fieldMap.keySet().size());
        assertEquals(cls.getDeclaredMethods().length, fieldMap.values().size() * 2);

        // verify the field
        List<Field> flist = Arrays.asList(cls.getFields());
        if (!(flist.containsAll(fieldMap.keySet()) && fieldMap.keySet().containsAll(flist))) {
            fail("the field is inconsistent");
        }

        // verify the method
        List<Method> asList = Arrays.asList(cls.getDeclaredMethods());
        List<Method> mapList = new ArrayList<Method>();
        for (Iterator<Method[]> it = fieldMap.values().iterator(); it.hasNext();) {
            mapList.addAll(Arrays.asList(it.next()));
        }
        if (!(asList.containsAll(mapList) && mapList.containsAll(asList))) {
            fail(" the method is inconsistent");
        }
    }

    @Test
    public void testCalGetMethodName() throws Exception {
        BeanClassUtil spy = PowerMockito.spy(bClassUtil);

        String prefix = "get";
        Field[] fields = BaseTypeClass.class.getFields();
        for (int i = 0; i < fields.length; i++) {
            if (!fields[i].getType().getName().equals("boolean")) {
                String getMethod = Whitebox.invokeMethod(spy, "calGetMethodName", fields[i]);
                if (!getMethod.startsWith(prefix)) {
                    fail("there exists method that's not started with " + prefix);
                }
            }
        }

        fields = ObjectClass.class.getFields();
        for (int i = 0; i < fields.length; i++) {
            if (!fields[i].getType().getName().equals("boolean")) {
                String getMethod = Whitebox.invokeMethod(spy, "calGetMethodName", fields[i]);
                if (!getMethod.startsWith(prefix)) {
                    fail("there exists method that's not started with " + prefix);
                }
            }
        }
    }

    @Test
    public void testCalSetMethodName() throws Exception {
        String prefix = "set";

        BeanClassUtil spy = PowerMockito.spy(bClassUtil);

        Field[] fields = BaseTypeClass.class.getFields();
        for (int i = 0; i < fields.length; i++) {
            String getMethod = Whitebox.invokeMethod(spy, "calSetMethodName", fields[i]);
            if (!getMethod.startsWith(prefix)) {
                fail("method name is not started with " + prefix);
            }
        }

        fields = ObjectClass.class.getFields();
        for (int i = 0; i < fields.length; i++) {
            String getMethod = Whitebox.invokeMethod(spy, "calSetMethodName", fields[i]);
            if (!getMethod.startsWith(prefix)) {
                fail("method name is not started with " + prefix);
            }
        }
    }

    @Test
    public void testIsColletionField() throws SecurityException, NoSuchFieldException {
        Field field = null;

        field = BaseTypeArrayClass.class.getField("intA");
        assertTrue(bClassUtil.isCollectionField(field));

        field = BaseTypeArrayClass.class.getField("longA");
        assertTrue(bClassUtil.isCollectionField(field));

        field = BaseTypeArrayClass.class.getField("floatA");
        assertTrue(bClassUtil.isCollectionField(field));

        field = BaseTypeArrayClass.class.getField("doubleA");
        assertTrue(bClassUtil.isCollectionField(field));

        field = BaseTypeArrayClass.class.getField("intA");
        assertTrue(bClassUtil.isCollectionField(field));

        field = BaseTypeArrayClass.class.getField("charA");
        assertTrue(bClassUtil.isCollectionField(field));

        field = BaseTypeArrayClass.class.getField("byteA");
        assertTrue(bClassUtil.isCollectionField(field));

        field = BaseTypeArrayClass.class.getField("booleanA");
        assertTrue(bClassUtil.isCollectionField(field));

        field = ObjectArrayClass.class.getField("objA");
        assertTrue(bClassUtil.isCollectionField(field));
        field = ObjectArrayClass.class.getField("beanClassUtilA");
        assertTrue(bClassUtil.isCollectionField(field));
        field = ObjectArrayClass.class.getField("swtA");
        assertTrue(bClassUtil.isCollectionField(field));
        field = ObjectArrayClass.class.getField("collectA");
        assertTrue(bClassUtil.isCollectionField(field));
        field = ObjectArrayClass.class.getField("inputStreamA");
        assertTrue(bClassUtil.isCollectionField(field));
        field = ObjectArrayClass.class.getField("clazzA");
        assertTrue(bClassUtil.isCollectionField(field));

        field = ObjectArrayClass.class.getField("stringAA");
        assertTrue(bClassUtil.isCollectionField(field));
    }

    @Test
    public void testIsJavaField() throws SecurityException, NoSuchFieldException {
        Field[] fields = BaseTypeClass.class.getFields();
        for (int i = 0; i < fields.length; i++) {
            assertTrue(bClassUtil.isJavaField(fields[i]));
        }

        fields = BaseTypeArrayClass.class.getFields();
        for (int i = 0; i < fields.length; i++) {
            assertFalse(bClassUtil.isJavaField(fields[i]));
        }

        Field field = ObjectClass.class.getField("obj");
        assertTrue(bClassUtil.isJavaField(field));

        field = ObjectClass.class.getField("beanClassUtil");
        assertFalse(bClassUtil.isJavaField(field));

        field = ObjectClass.class.getField("swt");
        assertFalse(bClassUtil.isJavaField(field));

        field = ObjectArrayClass.class.getField("stringAA");
        assertFalse(bClassUtil.isJavaField(field));

        field = ObjectClass.class.getField("collect");
        assertTrue(bClassUtil.isJavaField(field));

        field = ObjectClass.class.getField("inputStream");
        assertTrue(bClassUtil.isJavaField(field));

        field = ObjectClass.class.getField("clazz");
        assertTrue(bClassUtil.isJavaField(field));
    }

    @Test
    public void testIsJavaClass() {
        // base type field
        Field[] fields = BaseTypeClass.class.getFields();
        for (int i = 0; i < fields.length; i++) {
            assertTrue(fields[i].getType().getName(), bClassUtil.isJavaClass(fields[i].getType()));
        }

        // base type array field
        fields = BaseTypeArrayClass.class.getFields();
        for (int i = 0; i < fields.length; i++) {
            assertFalse(fields[i].getType().getName(), bClassUtil.isJavaClass(fields[i].getType()));
        }

        // any jdk class
        assertTrue(bClassUtil.isJavaClass(Object.class));
        assertTrue(bClassUtil.isJavaClass(String.class));
        assertTrue(bClassUtil.isJavaClass(Integer.class));
        assertTrue(bClassUtil.isJavaClass(Collection.class));
        assertTrue(bClassUtil.isJavaClass(InputStream.class));
        assertTrue(bClassUtil.isJavaClass(Class.class));

        // none jdk class
        assertFalse(bClassUtil.isJavaClass(SWT.class));
        assertFalse(bClassUtil.isJavaClass(BeanClassUtil.class));

        // base type array class
        assertFalse(bClassUtil.isJavaClass(new byte[12].getClass()));
        assertFalse(bClassUtil.isJavaClass(new char[12].getClass()));

        // jdk array(one dimension)
        assertTrue(bClassUtil.isJavaClass(new String[12].getClass()));
        assertTrue(bClassUtil.isJavaClass(new Object[12].getClass()));

        // jdk array(above one dimension)
        assertFalse(bClassUtil.isJavaClass(new String[12][3].getClass()));
        assertFalse(bClassUtil.isJavaClass(new Object[12][1].getClass()));
    }

    class BaseTypeClass {

        public int intField = 3;

        public long longField = 324l;

        public float floatField = 3.4f;

        public double doubleField = 3.9;

        public char charField = 'c';

        public byte byteField = 12;

        public boolean booleanField = false;

        public BaseTypeClass() {
        }
        public int getIntField() {
            return intField;
        }
        public void setIntField(int intField) {
            this.intField = intField;
        }
        public long getLongField() {
            return longField;
        }
        public void setLongField(long longField) {
            this.longField = longField;
        }
        public float getFloatField() {
            return floatField;
        }
        public void setFloatField(float floatField) {
            this.floatField = floatField;
        }
        public double getDoubleField() {
            return doubleField;
        }
        public void setDoubleField(double doubleField) {
            this.doubleField = doubleField;
        }
        public char getCharField() {
            return charField;
        }
        public void setCharField(char charField) {
            this.charField = charField;
        }
        public byte getByteField() {
            return byteField;
        }
        public void setByteField(byte byteField) {
            this.byteField = byteField;
        }
        public boolean isBooleanField() {
            return booleanField;
        }
        public void setBooleanField(boolean booleanField) {
            this.booleanField = booleanField;
        }
    }

    class BaseTypeArrayClass {

        public int[] intA;

        public long[] longA;

        public float[] floatA;

        public double[] doubleA;

        public char[] charA;

        public byte[] byteA;

        public boolean[] booleanA;
    }

    class ObjectClass {
        public Object obj;
        public BeanClassUtil beanClassUtil;
        public SWT swt;
        public Collection collect;
        public InputStream inputStream;
        public Class clazz;
        public Boolean bolezn;
        public WSMenu wsmenu;

        public Object getObj() {
            return obj;
        }
        public void setObj(Object obj) {
            this.obj = obj;
        }
        public BeanClassUtil getBeanClassUtil() {
            return beanClassUtil;
        }
        public void setBeanClassUtil(BeanClassUtil beanClassUtil) {
            this.beanClassUtil = beanClassUtil;
        }
        public SWT getSwt() {
            return swt;
        }
        public void setSwt(SWT swt) {
            this.swt = swt;
        }
        public Collection getCollect() {
            return collect;
        }
        public void setCollect(Collection collect) {
            this.collect = collect;
        }
        public InputStream getInputStream() {
            return inputStream;
        }
        public void setInputStream(InputStream inputStream) {
            this.inputStream = inputStream;
        }
        public Class getClazz() {
            return clazz;
        }
        public void setClazz(Class clazz) {
            this.clazz = clazz;
        }
        public Boolean getBolezn() {
            return bolezn;
        }
        public void setBolezn(Boolean bolezn) {
            this.bolezn = bolezn;
        }
        public WSMenu getWsmenu() {
            return wsmenu;
        }
        public void setWsmenu(WSMenu wsmenu) {
            this.wsmenu = wsmenu;
        }
    }

    class ObjectArrayClass {
        public Object[] objA;
        public BeanClassUtil[] beanClassUtilA;
        public SWT[] swtA;
        public Collection[] collectA;
        public InputStream[] inputStreamA;
        public Class[] clazzA;
        public Boolean[] boleznA;
        public String[][] stringAA;
    }
}
