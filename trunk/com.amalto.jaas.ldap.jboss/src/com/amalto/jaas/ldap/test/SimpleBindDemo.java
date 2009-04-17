package com.amalto.jaas.ldap.test;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

public class SimpleBindDemo {

    public static void main(String[] args) throws NamingException {

        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:10389/o=sevenSeas");

        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "cn=alban,ou=people,o=sevenSeas");
        env.put(Context.SECURITY_CREDENTIALS, "pass");

        try {
            Context ctx = new InitialContext(env);
            NamingEnumeration enm = ctx.list("");
            while (enm.hasMore()) {
                System.out.println(enm.next());
            }
            ctx.close();
        } catch (NamingException e) {
            System.out.println(e.getMessage());
        }
    }
}
