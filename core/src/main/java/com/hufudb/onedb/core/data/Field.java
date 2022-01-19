package com.hufudb.onedb.core.data;

import com.hufudb.onedb.rpc.OneDBCommon.FieldProto;

public class Field {
  String name;
  FieldType type;
  Level level;

  Field(String name, FieldType type, Level level) {
    this.name = name;
    this.type = type;
    this.level = level;
  }

  Field(String name, FieldType type) {
    this(name, type, Level.PUBLIC);
  }

  public Field(String name, int type, int level) {
    this(name, FieldType.values()[type], Level.values()[level]);
  }

  public Field(String name, int type) {
    this(name, FieldType.values()[type]);
  }

  public FieldProto toProto() {
    return FieldProto.newBuilder().setName(name).setType(type.ordinal()).build();
  }

  public static Field fromProto(FieldProto proto) {
    return new Field(proto.getName(), proto.getType());
  }

  public static Field of(String name, FieldType type) {
    return new Field(name, type);
  }

  public static Field of(String name, FieldType type, Level level) {
    return new Field(name, type, level);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this || (obj instanceof Field && ((Field) obj).name.equals(this.name) && ((Field) obj).type.equals(this.type) && ((Field) obj).level.equals(this.level));
  }

  @Override
  public String toString() {
    return String.format("%s:%s:%s", name, type.toString(), level.toString());
  }
}