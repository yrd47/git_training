/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package me.ele.goapns.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2017-02-15")
public class GoApnsSystemException extends TException implements org.apache.thrift.TBase<GoApnsSystemException, GoApnsSystemException._Fields>, java.io.Serializable, Cloneable, Comparable<GoApnsSystemException> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("GoApnsSystemException");

  private static final org.apache.thrift.protocol.TField ERROR_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("error_code", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField ERROR_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("error_name", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField MESSAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("message", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new GoApnsSystemExceptionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new GoApnsSystemExceptionTupleSchemeFactory());
  }

  /**
   * 
   * @see GoApnsErrorCode
   */
  public GoApnsErrorCode error_code; // required
  public String error_name; // required
  public String message; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see GoApnsErrorCode
     */
    ERROR_CODE((short)1, "error_code"),
    ERROR_NAME((short)2, "error_name"),
    MESSAGE((short)3, "message");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ERROR_CODE
          return ERROR_CODE;
        case 2: // ERROR_NAME
          return ERROR_NAME;
        case 3: // MESSAGE
          return MESSAGE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.MESSAGE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ERROR_CODE, new org.apache.thrift.meta_data.FieldMetaData("error_code", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, GoApnsErrorCode.class)));
    tmpMap.put(_Fields.ERROR_NAME, new org.apache.thrift.meta_data.FieldMetaData("error_name", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.MESSAGE, new org.apache.thrift.meta_data.FieldMetaData("message", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(GoApnsSystemException.class, metaDataMap);
  }

  public GoApnsSystemException() {
  }

  public GoApnsSystemException(
    GoApnsErrorCode error_code,
    String error_name)
  {
    this();
    this.error_code = error_code;
    this.error_name = error_name;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public GoApnsSystemException(GoApnsSystemException other) {
    if (other.isSetError_code()) {
      this.error_code = other.error_code;
    }
    if (other.isSetError_name()) {
      this.error_name = other.error_name;
    }
    if (other.isSetMessage()) {
      this.message = other.message;
    }
  }

  public GoApnsSystemException deepCopy() {
    return new GoApnsSystemException(this);
  }

  @Override
  public void clear() {
    this.error_code = null;
    this.error_name = null;
    this.message = null;
  }

  /**
   * 
   * @see GoApnsErrorCode
   */
  public GoApnsErrorCode getError_code() {
    return this.error_code;
  }

  /**
   * 
   * @see GoApnsErrorCode
   */
  public GoApnsSystemException setError_code(GoApnsErrorCode error_code) {
    this.error_code = error_code;
    return this;
  }

  public void unsetError_code() {
    this.error_code = null;
  }

  /** Returns true if field error_code is set (has been assigned a value) and false otherwise */
  public boolean isSetError_code() {
    return this.error_code != null;
  }

  public void setError_codeIsSet(boolean value) {
    if (!value) {
      this.error_code = null;
    }
  }

  public String getError_name() {
    return this.error_name;
  }

  public GoApnsSystemException setError_name(String error_name) {
    this.error_name = error_name;
    return this;
  }

  public void unsetError_name() {
    this.error_name = null;
  }

  /** Returns true if field error_name is set (has been assigned a value) and false otherwise */
  public boolean isSetError_name() {
    return this.error_name != null;
  }

  public void setError_nameIsSet(boolean value) {
    if (!value) {
      this.error_name = null;
    }
  }

  public String getMessage() {
    return this.message;
  }

  public GoApnsSystemException setMessage(String message) {
    this.message = message;
    return this;
  }

  public void unsetMessage() {
    this.message = null;
  }

  /** Returns true if field message is set (has been assigned a value) and false otherwise */
  public boolean isSetMessage() {
    return this.message != null;
  }

  public void setMessageIsSet(boolean value) {
    if (!value) {
      this.message = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ERROR_CODE:
      if (value == null) {
        unsetError_code();
      } else {
        setError_code((GoApnsErrorCode)value);
      }
      break;

    case ERROR_NAME:
      if (value == null) {
        unsetError_name();
      } else {
        setError_name((String)value);
      }
      break;

    case MESSAGE:
      if (value == null) {
        unsetMessage();
      } else {
        setMessage((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ERROR_CODE:
      return getError_code();

    case ERROR_NAME:
      return getError_name();

    case MESSAGE:
      return getMessage();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ERROR_CODE:
      return isSetError_code();
    case ERROR_NAME:
      return isSetError_name();
    case MESSAGE:
      return isSetMessage();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof GoApnsSystemException)
      return this.equals((GoApnsSystemException)that);
    return false;
  }

  public boolean equals(GoApnsSystemException that) {
    if (that == null)
      return false;

    boolean this_present_error_code = true && this.isSetError_code();
    boolean that_present_error_code = true && that.isSetError_code();
    if (this_present_error_code || that_present_error_code) {
      if (!(this_present_error_code && that_present_error_code))
        return false;
      if (!this.error_code.equals(that.error_code))
        return false;
    }

    boolean this_present_error_name = true && this.isSetError_name();
    boolean that_present_error_name = true && that.isSetError_name();
    if (this_present_error_name || that_present_error_name) {
      if (!(this_present_error_name && that_present_error_name))
        return false;
      if (!this.error_name.equals(that.error_name))
        return false;
    }

    boolean this_present_message = true && this.isSetMessage();
    boolean that_present_message = true && that.isSetMessage();
    if (this_present_message || that_present_message) {
      if (!(this_present_message && that_present_message))
        return false;
      if (!this.message.equals(that.message))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_error_code = true && (isSetError_code());
    list.add(present_error_code);
    if (present_error_code)
      list.add(error_code.getValue());

    boolean present_error_name = true && (isSetError_name());
    list.add(present_error_name);
    if (present_error_name)
      list.add(error_name);

    boolean present_message = true && (isSetMessage());
    list.add(present_message);
    if (present_message)
      list.add(message);

    return list.hashCode();
  }

  @Override
  public int compareTo(GoApnsSystemException other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetError_code()).compareTo(other.isSetError_code());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetError_code()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.error_code, other.error_code);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetError_name()).compareTo(other.isSetError_name());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetError_name()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.error_name, other.error_name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMessage()).compareTo(other.isSetMessage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMessage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.message, other.message);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("GoApnsSystemException(");
    boolean first = true;

    sb.append("error_code:");
    if (this.error_code == null) {
      sb.append("null");
    } else {
      sb.append(this.error_code);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("error_name:");
    if (this.error_name == null) {
      sb.append("null");
    } else {
      sb.append(this.error_name);
    }
    first = false;
    if (isSetMessage()) {
      if (!first) sb.append(", ");
      sb.append("message:");
      if (this.message == null) {
        sb.append("null");
      } else {
        sb.append(this.message);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (error_code == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'error_code' was not present! Struct: " + toString());
    }
    if (error_name == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'error_name' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class GoApnsSystemExceptionStandardSchemeFactory implements SchemeFactory {
    public GoApnsSystemExceptionStandardScheme getScheme() {
      return new GoApnsSystemExceptionStandardScheme();
    }
  }

  private static class GoApnsSystemExceptionStandardScheme extends StandardScheme<GoApnsSystemException> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, GoApnsSystemException struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ERROR_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.error_code = me.ele.goapns.thrift.GoApnsErrorCode.findByValue(iprot.readI32());
              struct.setError_codeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ERROR_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.error_name = iprot.readString();
              struct.setError_nameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // MESSAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.message = iprot.readString();
              struct.setMessageIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, GoApnsSystemException struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.error_code != null) {
        oprot.writeFieldBegin(ERROR_CODE_FIELD_DESC);
        oprot.writeI32(struct.error_code.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.error_name != null) {
        oprot.writeFieldBegin(ERROR_NAME_FIELD_DESC);
        oprot.writeString(struct.error_name);
        oprot.writeFieldEnd();
      }
      if (struct.message != null) {
        if (struct.isSetMessage()) {
          oprot.writeFieldBegin(MESSAGE_FIELD_DESC);
          oprot.writeString(struct.message);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class GoApnsSystemExceptionTupleSchemeFactory implements SchemeFactory {
    public GoApnsSystemExceptionTupleScheme getScheme() {
      return new GoApnsSystemExceptionTupleScheme();
    }
  }

  private static class GoApnsSystemExceptionTupleScheme extends TupleScheme<GoApnsSystemException> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, GoApnsSystemException struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.error_code.getValue());
      oprot.writeString(struct.error_name);
      BitSet optionals = new BitSet();
      if (struct.isSetMessage()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetMessage()) {
        oprot.writeString(struct.message);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, GoApnsSystemException struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.error_code = me.ele.goapns.thrift.GoApnsErrorCode.findByValue(iprot.readI32());
      struct.setError_codeIsSet(true);
      struct.error_name = iprot.readString();
      struct.setError_nameIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.message = iprot.readString();
        struct.setMessageIsSet(true);
      }
    }
  }

}

