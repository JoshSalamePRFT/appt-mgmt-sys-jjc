package com.jjcperf.userservice.phoneHandling;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;

public class PhoneNumberType implements UserType {
    @Override
    public int[] sqlTypes() {
        return new int[]{Types.VARCHAR, Types.VARCHAR};
    }

    @Override
    public Class returnedClass() {
        return PhoneNumber.class;
    }

    @Override
    public boolean equals(Object o, Object o1) throws HibernateException {
        return false;
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        return 0;
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException, SQLException {
        if (resultSet.wasNull())
            return null;

        return new PhoneNumber(strings[0], strings[1]);
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int index, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException, SQLException {
            if (Objects.isNull(o)) {
                preparedStatement.setNull(index, Types.VARCHAR);
                preparedStatement.setNull(index + 1, Types.VARCHAR);
            } else {
                PhoneNumber phoneNumber = (PhoneNumber) o;
                preparedStatement.setString(index,phoneNumber.getValue());
                preparedStatement.setString(index+1,phoneNumber.getLocale());
            }
    }

    @Override
    public Object deepCopy(Object o) throws HibernateException {
        return null;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable serializable, Object o) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(Object o, Object o1, Object o2) throws HibernateException {
        return null;
    }
}
