// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;

public final class TypeAdapters
{
    private static final class EnumTypeAdapter extends TypeAdapter
    {

        private final Map constantToName;
        private final Map nameToConstant;

        public Enum read(JsonReader jsonreader)
            throws IOException
        {
            if (jsonreader.peek() == JsonToken.NULL)
            {
                jsonreader.nextNull();
                return null;
            } else
            {
                return (Enum)nameToConstant.get(jsonreader.nextString());
            }
        }

        public volatile Object read(JsonReader jsonreader)
            throws IOException
        {
            return read(jsonreader);
        }

        public void write(JsonWriter jsonwriter, Enum enum)
            throws IOException
        {
            String s;
            if (enum == null)
            {
                s = null;
            } else
            {
                s = (String)constantToName.get(enum);
            }
            jsonwriter.value(s);
        }

        public volatile void write(JsonWriter jsonwriter, Object obj)
            throws IOException
        {
            write(jsonwriter, (Enum)obj);
        }

        public EnumTypeAdapter(Class class1)
        {
            nameToConstant = new HashMap();
            constantToName = new HashMap();
            Enum aenum[];
            int i;
            int j;
            Enum enum;
            String s;
            SerializedName serializedname;
            try
            {
                aenum = (Enum[])class1.getEnumConstants();
                i = aenum.length;
            }
            catch (NoSuchFieldException nosuchfieldexception)
            {
                throw new AssertionError();
            }
            j = 0;
            if (j >= i)
            {
                break; /* Loop/switch isn't completed */
            }
            enum = aenum[j];
            s = enum.name();
            serializedname = (SerializedName)class1.getField(s).getAnnotation(com/google/gson/annotations/SerializedName);
            if (serializedname == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            s = serializedname.value();
            nameToConstant.put(s, enum);
            constantToName.put(enum, s);
            j++;
            if (true) goto _L2; else goto _L1
_L2:
            break MISSING_BLOCK_LABEL_41;
_L1:
        }
    }


    public static final TypeAdapter BIG_DECIMAL = new TypeAdapter() {

        public volatile Object read(JsonReader jsonreader)
            throws IOException
        {
            return read(jsonreader);
        }

        public BigDecimal read(JsonReader jsonreader)
            throws IOException
        {
            if (jsonreader.peek() == JsonToken.NULL)
            {
                jsonreader.nextNull();
                return null;
            }
            BigDecimal bigdecimal;
            try
            {
                bigdecimal = new BigDecimal(jsonreader.nextString());
            }
            catch (NumberFormatException numberformatexception)
            {
                throw new JsonSyntaxException(numberformatexception);
            }
            return bigdecimal;
        }

        public volatile void write(JsonWriter jsonwriter, Object obj)
            throws IOException
        {
            write(jsonwriter, (BigDecimal)obj);
        }

        public void write(JsonWriter jsonwriter, BigDecimal bigdecimal)
            throws IOException
        {
            jsonwriter.value(bigdecimal);
        }

    };
    public static final TypeAdapter BIG_INTEGER = new TypeAdapter() {

        public volatile Object read(JsonReader jsonreader)
            throws IOException
        {
            return read(jsonreader);
        }

        public BigInteger read(JsonReader jsonreader)
            throws IOException
        {
            if (jsonreader.peek() == JsonToken.NULL)
            {
                jsonreader.nextNull();
                return null;
            }
            BigInteger biginteger;
            try
            {
                biginteger = new BigInteger(jsonreader.nextString());
            }
            catch (NumberFormatException numberformatexception)
            {
                throw new JsonSyntaxException(numberformatexception);
            }
            return biginteger;
        }

        public volatile void write(JsonWriter jsonwriter, Object obj)
            throws IOException
        {
            write(jsonwriter, (BigInteger)obj);
        }

        public void write(JsonWriter jsonwriter, BigInteger biginteger)
            throws IOException
        {
            jsonwriter.value(biginteger);
        }

    };
    public static final TypeAdapter BIT_SET;
    public static final TypeAdapterFactory BIT_SET_FACTORY;
    public static final TypeAdapter BOOLEAN;
    public static final TypeAdapter BOOLEAN_AS_STRING = new TypeAdapter() {

        public Boolean read(JsonReader jsonreader)
            throws IOException
        {
            if (jsonreader.peek() == JsonToken.NULL)
            {
                jsonreader.nextNull();
                return null;
            } else
            {
                return Boolean.valueOf(jsonreader.nextString());
            }
        }

        public volatile Object read(JsonReader jsonreader)
            throws IOException
        {
            return read(jsonreader);
        }

        public void write(JsonWriter jsonwriter, Boolean boolean1)
            throws IOException
        {
            String s;
            if (boolean1 == null)
            {
                s = "null";
            } else
            {
                s = boolean1.toString();
            }
            jsonwriter.value(s);
        }

        public volatile void write(JsonWriter jsonwriter, Object obj)
            throws IOException
        {
            write(jsonwriter, (Boolean)obj);
        }

    };
    public static final TypeAdapterFactory BOOLEAN_FACTORY;
    public static final TypeAdapter BYTE;
    public static final TypeAdapterFactory BYTE_FACTORY;
    public static final TypeAdapter CALENDAR;
    public static final TypeAdapterFactory CALENDAR_FACTORY;
    public static final TypeAdapter CHARACTER;
    public static final TypeAdapterFactory CHARACTER_FACTORY;
    public static final TypeAdapter CLASS;
    public static final TypeAdapterFactory CLASS_FACTORY;
    public static final TypeAdapter DOUBLE = new TypeAdapter() {

        public Number read(JsonReader jsonreader)
            throws IOException
        {
            if (jsonreader.peek() == JsonToken.NULL)
            {
                jsonreader.nextNull();
                return null;
            } else
            {
                return Double.valueOf(jsonreader.nextDouble());
            }
        }

        public volatile Object read(JsonReader jsonreader)
            throws IOException
        {
            return read(jsonreader);
        }

        public void write(JsonWriter jsonwriter, Number number)
            throws IOException
        {
            jsonwriter.value(number);
        }

        public volatile void write(JsonWriter jsonwriter, Object obj)
            throws IOException
        {
            write(jsonwriter, (Number)obj);
        }

    };
    public static final TypeAdapterFactory ENUM_FACTORY = newEnumTypeHierarchyFactory();
    public static final TypeAdapter FLOAT = new TypeAdapter() {

        public Number read(JsonReader jsonreader)
            throws IOException
        {
            if (jsonreader.peek() == JsonToken.NULL)
            {
                jsonreader.nextNull();
                return null;
            } else
            {
                return Float.valueOf((float)jsonreader.nextDouble());
            }
        }

        public volatile Object read(JsonReader jsonreader)
            throws IOException
        {
            return read(jsonreader);
        }

        public void write(JsonWriter jsonwriter, Number number)
            throws IOException
        {
            jsonwriter.value(number);
        }

        public volatile void write(JsonWriter jsonwriter, Object obj)
            throws IOException
        {
            write(jsonwriter, (Number)obj);
        }

    };
    public static final TypeAdapter INET_ADDRESS;
    public static final TypeAdapterFactory INET_ADDRESS_FACTORY;
    public static final TypeAdapter INTEGER;
    public static final TypeAdapterFactory INTEGER_FACTORY;
    public static final TypeAdapter JSON_ELEMENT;
    public static final TypeAdapterFactory JSON_ELEMENT_FACTORY;
    public static final TypeAdapter LOCALE;
    public static final TypeAdapterFactory LOCALE_FACTORY;
    public static final TypeAdapter LONG = new TypeAdapter() {

        public Number read(JsonReader jsonreader)
            throws IOException
        {
            if (jsonreader.peek() == JsonToken.NULL)
            {
                jsonreader.nextNull();
                return null;
            }
            Long long1;
            try
            {
                long1 = Long.valueOf(jsonreader.nextLong());
            }
            catch (NumberFormatException numberformatexception)
            {
                throw new JsonSyntaxException(numberformatexception);
            }
            return long1;
        }

        public volatile Object read(JsonReader jsonreader)
            throws IOException
        {
            return read(jsonreader);
        }

        public void write(JsonWriter jsonwriter, Number number)
            throws IOException
        {
            jsonwriter.value(number);
        }

        public volatile void write(JsonWriter jsonwriter, Object obj)
            throws IOException
        {
            write(jsonwriter, (Number)obj);
        }

    };
    public static final TypeAdapter NUMBER;
    public static final TypeAdapterFactory NUMBER_FACTORY;
    public static final TypeAdapter SHORT;
    public static final TypeAdapterFactory SHORT_FACTORY;
    public static final TypeAdapter STRING;
    public static final TypeAdapter STRING_BUFFER;
    public static final TypeAdapterFactory STRING_BUFFER_FACTORY;
    public static final TypeAdapter STRING_BUILDER;
    public static final TypeAdapterFactory STRING_BUILDER_FACTORY;
    public static final TypeAdapterFactory STRING_FACTORY;
    public static final TypeAdapterFactory TIMESTAMP_FACTORY = new TypeAdapterFactory() {

        public TypeAdapter create(Gson gson, TypeToken typetoken)
        {
            if (typetoken.getRawType() != java/sql/Timestamp)
            {
                return null;
            } else
            {
                return gson.getAdapter(java/util/Date). new TypeAdapter() {

                    final _cls22 this$0;
                    final TypeAdapter val$dateTypeAdapter;

                    public volatile Object read(JsonReader jsonreader)
                        throws IOException
                    {
                        return read(jsonreader);
                    }

                    public Timestamp read(JsonReader jsonreader)
                        throws IOException
                    {
                        Date date = (Date)dateTypeAdapter.read(jsonreader);
                        if (date != null)
                        {
                            return new Timestamp(date.getTime());
                        } else
                        {
                            return null;
                        }
                    }

                    public volatile void write(JsonWriter jsonwriter, Object obj)
                        throws IOException
                    {
                        write(jsonwriter, (Timestamp)obj);
                    }

                    public void write(JsonWriter jsonwriter, Timestamp timestamp)
                        throws IOException
                    {
                        dateTypeAdapter.write(jsonwriter, timestamp);
                    }

            
            {
                this$0 = final__pcls22;
                dateTypeAdapter = TypeAdapter.this;
                super();
            }
                };
            }
        }

    };
    public static final TypeAdapter URI;
    public static final TypeAdapterFactory URI_FACTORY;
    public static final TypeAdapter URL;
    public static final TypeAdapterFactory URL_FACTORY;
    public static final TypeAdapter UUID;
    public static final TypeAdapterFactory UUID_FACTORY;

    public static TypeAdapterFactory newEnumTypeHierarchyFactory()
    {
        return new TypeAdapterFactory() {

            public TypeAdapter create(Gson gson, TypeToken typetoken)
            {
                Class class1 = typetoken.getRawType();
                if (!java/lang/Enum.isAssignableFrom(class1) || class1 == java/lang/Enum)
                {
                    return null;
                }
                if (!class1.isEnum())
                {
                    class1 = class1.getSuperclass();
                }
                return new EnumTypeAdapter(class1);
            }

        };
    }

    public static TypeAdapterFactory newFactory(Class class1, TypeAdapter typeadapter)
    {
        return new TypeAdapterFactory(class1, typeadapter) {

            final Class val$type;
            final TypeAdapter val$typeAdapter;

            public TypeAdapter create(Gson gson, TypeToken typetoken)
            {
                if (typetoken.getRawType() == type)
                {
                    return typeAdapter;
                } else
                {
                    return null;
                }
            }

            public String toString()
            {
                return (new StringBuilder()).append("Factory[type=").append(type.getName()).append(",adapter=").append(typeAdapter).append("]").toString();
            }

            
            {
                type = class1;
                typeAdapter = typeadapter;
                super();
            }
        };
    }

    public static TypeAdapterFactory newFactory(Class class1, Class class2, TypeAdapter typeadapter)
    {
        return new TypeAdapterFactory(class1, class2, typeadapter) {

            final Class val$boxed;
            final TypeAdapter val$typeAdapter;
            final Class val$unboxed;

            public TypeAdapter create(Gson gson, TypeToken typetoken)
            {
                Class class3 = typetoken.getRawType();
                if (class3 == unboxed || class3 == boxed)
                {
                    return typeAdapter;
                } else
                {
                    return null;
                }
            }

            public String toString()
            {
                return (new StringBuilder()).append("Factory[type=").append(boxed.getName()).append("+").append(unboxed.getName()).append(",adapter=").append(typeAdapter).append("]").toString();
            }

            
            {
                unboxed = class1;
                boxed = class2;
                typeAdapter = typeadapter;
                super();
            }
        };
    }

    public static TypeAdapterFactory newFactoryForMultipleTypes(Class class1, Class class2, TypeAdapter typeadapter)
    {
        return new TypeAdapterFactory(class1, class2, typeadapter) {

            final Class val$base;
            final Class val$sub;
            final TypeAdapter val$typeAdapter;

            public TypeAdapter create(Gson gson, TypeToken typetoken)
            {
                Class class3 = typetoken.getRawType();
                if (class3 == base || class3 == sub)
                {
                    return typeAdapter;
                } else
                {
                    return null;
                }
            }

            public String toString()
            {
                return (new StringBuilder()).append("Factory[type=").append(base.getName()).append("+").append(sub.getName()).append(",adapter=").append(typeAdapter).append("]").toString();
            }

            
            {
                base = class1;
                sub = class2;
                typeAdapter = typeadapter;
                super();
            }
        };
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class class1, TypeAdapter typeadapter)
    {
        return new TypeAdapterFactory(class1, typeadapter) {

            final Class val$clazz;
            final TypeAdapter val$typeAdapter;

            public TypeAdapter create(Gson gson, TypeToken typetoken)
            {
                if (clazz.isAssignableFrom(typetoken.getRawType()))
                {
                    return typeAdapter;
                } else
                {
                    return null;
                }
            }

            public String toString()
            {
                return (new StringBuilder()).append("Factory[typeHierarchy=").append(clazz.getName()).append(",adapter=").append(typeAdapter).append("]").toString();
            }

            
            {
                clazz = class1;
                typeAdapter = typeadapter;
                super();
            }
        };
    }

    static 
    {
        CLASS = new TypeAdapter() {

            public Class read(JsonReader jsonreader)
                throws IOException
            {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }

            public volatile Object read(JsonReader jsonreader)
                throws IOException
            {
                return read(jsonreader);
            }

            public void write(JsonWriter jsonwriter, Class class1)
                throws IOException
            {
                throw new UnsupportedOperationException((new StringBuilder()).append("Attempted to serialize java.lang.Class: ").append(class1.getName()).append(". Forgot to register a type adapter?").toString());
            }

            public volatile void write(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                write(jsonwriter, (Class)obj);
            }

        };
        CLASS_FACTORY = newFactory(java/lang/Class, CLASS);
        BIT_SET = new TypeAdapter() {

            public volatile Object read(JsonReader jsonreader)
                throws IOException
            {
                return read(jsonreader);
            }

            public BitSet read(JsonReader jsonreader)
                throws IOException
            {
                BitSet bitset;
                int i;
                JsonToken jsontoken;
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                }
                bitset = new BitSet();
                jsonreader.beginArray();
                i = 0;
                jsontoken = jsonreader.peek();
_L2:
                boolean flag;
                if (jsontoken == JsonToken.END_ARRAY)
                {
                    break MISSING_BLOCK_LABEL_215;
                }
                static class _cls32
                {

                    static final int $SwitchMap$com$google$gson$stream$JsonToken[];

                    static 
                    {
                        $SwitchMap$com$google$gson$stream$JsonToken = new int[JsonToken.values().length];
                        try
                        {
                            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror) { }
                        try
                        {
                            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
                        }
                        catch (NoSuchFieldError nosuchfielderror4) { }
                        try
                        {
                            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
                        }
                        catch (NoSuchFieldError nosuchfielderror5) { }
                        try
                        {
                            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_DOCUMENT.ordinal()] = 7;
                        }
                        catch (NoSuchFieldError nosuchfielderror6) { }
                        try
                        {
                            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NAME.ordinal()] = 8;
                        }
                        catch (NoSuchFieldError nosuchfielderror7) { }
                        try
                        {
                            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_OBJECT.ordinal()] = 9;
                        }
                        catch (NoSuchFieldError nosuchfielderror8) { }
                        try
                        {
                            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_ARRAY.ordinal()] = 10;
                        }
                        catch (NoSuchFieldError nosuchfielderror9)
                        {
                            return;
                        }
                    }
                }

                switch (_cls32..SwitchMap.com.google.gson.stream.JsonToken[jsontoken.ordinal()])
                {
                default:
                    throw new JsonSyntaxException((new StringBuilder()).append("Invalid bitset value type: ").append(jsontoken).toString());

                case 2: // '\002'
                    break; /* Loop/switch isn't completed */

                case 3: // '\003'
                    break MISSING_BLOCK_LABEL_155;

                case 1: // '\001'
                    if (jsonreader.nextInt() != 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    break;
                }
_L3:
                if (flag)
                {
                    bitset.set(i);
                }
                i++;
                jsontoken = jsonreader.peek();
                if (true) goto _L2; else goto _L1
_L1:
                flag = jsonreader.nextBoolean();
                  goto _L3
                String s = jsonreader.nextString();
                int j;
                try
                {
                    j = Integer.parseInt(s);
                }
                catch (NumberFormatException numberformatexception)
                {
                    throw new JsonSyntaxException((new StringBuilder()).append("Error: Expecting: bitset number value (1, 0), Found: ").append(s).toString());
                }
                if (j != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                  goto _L3
                jsonreader.endArray();
                return bitset;
            }

            public volatile void write(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                write(jsonwriter, (BitSet)obj);
            }

            public void write(JsonWriter jsonwriter, BitSet bitset)
                throws IOException
            {
                if (bitset == null)
                {
                    jsonwriter.nullValue();
                    return;
                }
                jsonwriter.beginArray();
                int i = 0;
                while (i < bitset.length()) 
                {
                    int j;
                    if (bitset.get(i))
                    {
                        j = 1;
                    } else
                    {
                        j = 0;
                    }
                    jsonwriter.value(j);
                    i++;
                }
                jsonwriter.endArray();
            }

        };
        BIT_SET_FACTORY = newFactory(java/util/BitSet, BIT_SET);
        BOOLEAN = new TypeAdapter() {

            public Boolean read(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                }
                if (jsonreader.peek() == JsonToken.STRING)
                {
                    return Boolean.valueOf(Boolean.parseBoolean(jsonreader.nextString()));
                } else
                {
                    return Boolean.valueOf(jsonreader.nextBoolean());
                }
            }

            public volatile Object read(JsonReader jsonreader)
                throws IOException
            {
                return read(jsonreader);
            }

            public void write(JsonWriter jsonwriter, Boolean boolean1)
                throws IOException
            {
                if (boolean1 == null)
                {
                    jsonwriter.nullValue();
                    return;
                } else
                {
                    jsonwriter.value(boolean1.booleanValue());
                    return;
                }
            }

            public volatile void write(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                write(jsonwriter, (Boolean)obj);
            }

        };
        BOOLEAN_FACTORY = newFactory(Boolean.TYPE, java/lang/Boolean, BOOLEAN);
        BYTE = new TypeAdapter() {

            public Number read(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                }
                Byte byte1;
                try
                {
                    byte1 = Byte.valueOf((byte)jsonreader.nextInt());
                }
                catch (NumberFormatException numberformatexception)
                {
                    throw new JsonSyntaxException(numberformatexception);
                }
                return byte1;
            }

            public volatile Object read(JsonReader jsonreader)
                throws IOException
            {
                return read(jsonreader);
            }

            public void write(JsonWriter jsonwriter, Number number)
                throws IOException
            {
                jsonwriter.value(number);
            }

            public volatile void write(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                write(jsonwriter, (Number)obj);
            }

        };
        BYTE_FACTORY = newFactory(Byte.TYPE, java/lang/Byte, BYTE);
        SHORT = new TypeAdapter() {

            public Number read(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                }
                Short short1;
                try
                {
                    short1 = Short.valueOf((short)jsonreader.nextInt());
                }
                catch (NumberFormatException numberformatexception)
                {
                    throw new JsonSyntaxException(numberformatexception);
                }
                return short1;
            }

            public volatile Object read(JsonReader jsonreader)
                throws IOException
            {
                return read(jsonreader);
            }

            public void write(JsonWriter jsonwriter, Number number)
                throws IOException
            {
                jsonwriter.value(number);
            }

            public volatile void write(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                write(jsonwriter, (Number)obj);
            }

        };
        SHORT_FACTORY = newFactory(Short.TYPE, java/lang/Short, SHORT);
        INTEGER = new TypeAdapter() {

            public Number read(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                }
                Integer integer;
                try
                {
                    integer = Integer.valueOf(jsonreader.nextInt());
                }
                catch (NumberFormatException numberformatexception)
                {
                    throw new JsonSyntaxException(numberformatexception);
                }
                return integer;
            }

            public volatile Object read(JsonReader jsonreader)
                throws IOException
            {
                return read(jsonreader);
            }

            public void write(JsonWriter jsonwriter, Number number)
                throws IOException
            {
                jsonwriter.value(number);
            }

            public volatile void write(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                write(jsonwriter, (Number)obj);
            }

        };
        INTEGER_FACTORY = newFactory(Integer.TYPE, java/lang/Integer, INTEGER);
        NUMBER = new TypeAdapter() {

            public Number read(JsonReader jsonreader)
                throws IOException
            {
                JsonToken jsontoken = jsonreader.peek();
                switch (_cls32..SwitchMap.com.google.gson.stream.JsonToken[jsontoken.ordinal()])
                {
                case 2: // '\002'
                case 3: // '\003'
                default:
                    throw new JsonSyntaxException((new StringBuilder()).append("Expecting number, got: ").append(jsontoken).toString());

                case 4: // '\004'
                    jsonreader.nextNull();
                    return null;

                case 1: // '\001'
                    return new LazilyParsedNumber(jsonreader.nextString());
                }
            }

            public volatile Object read(JsonReader jsonreader)
                throws IOException
            {
                return read(jsonreader);
            }

            public void write(JsonWriter jsonwriter, Number number)
                throws IOException
            {
                jsonwriter.value(number);
            }

            public volatile void write(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                write(jsonwriter, (Number)obj);
            }

        };
        NUMBER_FACTORY = newFactory(java/lang/Number, NUMBER);
        CHARACTER = new TypeAdapter() {

            public Character read(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                }
                String s = jsonreader.nextString();
                if (s.length() != 1)
                {
                    throw new JsonSyntaxException((new StringBuilder()).append("Expecting character, got: ").append(s).toString());
                } else
                {
                    return Character.valueOf(s.charAt(0));
                }
            }

            public volatile Object read(JsonReader jsonreader)
                throws IOException
            {
                return read(jsonreader);
            }

            public void write(JsonWriter jsonwriter, Character character)
                throws IOException
            {
                String s;
                if (character == null)
                {
                    s = null;
                } else
                {
                    s = String.valueOf(character);
                }
                jsonwriter.value(s);
            }

            public volatile void write(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                write(jsonwriter, (Character)obj);
            }

        };
        CHARACTER_FACTORY = newFactory(Character.TYPE, java/lang/Character, CHARACTER);
        STRING = new TypeAdapter() {

            public volatile Object read(JsonReader jsonreader)
                throws IOException
            {
                return read(jsonreader);
            }

            public String read(JsonReader jsonreader)
                throws IOException
            {
                JsonToken jsontoken = jsonreader.peek();
                if (jsontoken == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                }
                if (jsontoken == JsonToken.BOOLEAN)
                {
                    return Boolean.toString(jsonreader.nextBoolean());
                } else
                {
                    return jsonreader.nextString();
                }
            }

            public volatile void write(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                write(jsonwriter, (String)obj);
            }

            public void write(JsonWriter jsonwriter, String s)
                throws IOException
            {
                jsonwriter.value(s);
            }

        };
        STRING_FACTORY = newFactory(java/lang/String, STRING);
        STRING_BUILDER = new TypeAdapter() {

            public volatile Object read(JsonReader jsonreader)
                throws IOException
            {
                return read(jsonreader);
            }

            public StringBuilder read(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                } else
                {
                    return new StringBuilder(jsonreader.nextString());
                }
            }

            public volatile void write(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                write(jsonwriter, (StringBuilder)obj);
            }

            public void write(JsonWriter jsonwriter, StringBuilder stringbuilder)
                throws IOException
            {
                String s;
                if (stringbuilder == null)
                {
                    s = null;
                } else
                {
                    s = stringbuilder.toString();
                }
                jsonwriter.value(s);
            }

        };
        STRING_BUILDER_FACTORY = newFactory(java/lang/StringBuilder, STRING_BUILDER);
        STRING_BUFFER = new TypeAdapter() {

            public volatile Object read(JsonReader jsonreader)
                throws IOException
            {
                return read(jsonreader);
            }

            public StringBuffer read(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                } else
                {
                    return new StringBuffer(jsonreader.nextString());
                }
            }

            public volatile void write(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                write(jsonwriter, (StringBuffer)obj);
            }

            public void write(JsonWriter jsonwriter, StringBuffer stringbuffer)
                throws IOException
            {
                String s;
                if (stringbuffer == null)
                {
                    s = null;
                } else
                {
                    s = stringbuffer.toString();
                }
                jsonwriter.value(s);
            }

        };
        STRING_BUFFER_FACTORY = newFactory(java/lang/StringBuffer, STRING_BUFFER);
        URL = new TypeAdapter() {

            public volatile Object read(JsonReader jsonreader)
                throws IOException
            {
                return read(jsonreader);
            }

            public URL read(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                } else
                {
                    String s = jsonreader.nextString();
                    if (!"null".equals(s))
                    {
                        return new URL(s);
                    }
                }
                return null;
            }

            public volatile void write(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                write(jsonwriter, (URL)obj);
            }

            public void write(JsonWriter jsonwriter, URL url)
                throws IOException
            {
                String s;
                if (url == null)
                {
                    s = null;
                } else
                {
                    s = url.toExternalForm();
                }
                jsonwriter.value(s);
            }

        };
        URL_FACTORY = newFactory(java/net/URL, URL);
        URI = new TypeAdapter() {

            public volatile Object read(JsonReader jsonreader)
                throws IOException
            {
                return read(jsonreader);
            }

            public URI read(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() != JsonToken.NULL) goto _L2; else goto _L1
_L1:
                jsonreader.nextNull();
_L4:
                return null;
_L2:
                String s = jsonreader.nextString();
                if ("null".equals(s)) goto _L4; else goto _L3
_L3:
                URI uri = new URI(s);
                return uri;
                URISyntaxException urisyntaxexception;
                urisyntaxexception;
                throw new JsonIOException(urisyntaxexception);
            }

            public volatile void write(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                write(jsonwriter, (URI)obj);
            }

            public void write(JsonWriter jsonwriter, URI uri)
                throws IOException
            {
                String s;
                if (uri == null)
                {
                    s = null;
                } else
                {
                    s = uri.toASCIIString();
                }
                jsonwriter.value(s);
            }

        };
        URI_FACTORY = newFactory(java/net/URI, URI);
        INET_ADDRESS = new TypeAdapter() {

            public volatile Object read(JsonReader jsonreader)
                throws IOException
            {
                return read(jsonreader);
            }

            public InetAddress read(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                } else
                {
                    return InetAddress.getByName(jsonreader.nextString());
                }
            }

            public volatile void write(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                write(jsonwriter, (InetAddress)obj);
            }

            public void write(JsonWriter jsonwriter, InetAddress inetaddress)
                throws IOException
            {
                String s;
                if (inetaddress == null)
                {
                    s = null;
                } else
                {
                    s = inetaddress.getHostAddress();
                }
                jsonwriter.value(s);
            }

        };
        INET_ADDRESS_FACTORY = newTypeHierarchyFactory(java/net/InetAddress, INET_ADDRESS);
        UUID = new TypeAdapter() {

            public volatile Object read(JsonReader jsonreader)
                throws IOException
            {
                return read(jsonreader);
            }

            public UUID read(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                } else
                {
                    return java.util.UUID.fromString(jsonreader.nextString());
                }
            }

            public volatile void write(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                write(jsonwriter, (UUID)obj);
            }

            public void write(JsonWriter jsonwriter, UUID uuid)
                throws IOException
            {
                String s;
                if (uuid == null)
                {
                    s = null;
                } else
                {
                    s = uuid.toString();
                }
                jsonwriter.value(s);
            }

        };
        UUID_FACTORY = newFactory(java/util/UUID, UUID);
        CALENDAR = new TypeAdapter() {

            public volatile Object read(JsonReader jsonreader)
                throws IOException
            {
                return read(jsonreader);
            }

            public Calendar read(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                }
                jsonreader.beginObject();
                int i = 0;
                int j = 0;
                int k = 0;
                int l = 0;
                int i1 = 0;
                int j1 = 0;
                do
                {
                    if (jsonreader.peek() == JsonToken.END_OBJECT)
                    {
                        break;
                    }
                    String s = jsonreader.nextName();
                    int k1 = jsonreader.nextInt();
                    if ("year".equals(s))
                    {
                        i = k1;
                    } else
                    if ("month".equals(s))
                    {
                        j = k1;
                    } else
                    if ("dayOfMonth".equals(s))
                    {
                        k = k1;
                    } else
                    if ("hourOfDay".equals(s))
                    {
                        l = k1;
                    } else
                    if ("minute".equals(s))
                    {
                        i1 = k1;
                    } else
                    if ("second".equals(s))
                    {
                        j1 = k1;
                    }
                } while (true);
                jsonreader.endObject();
                return new GregorianCalendar(i, j, k, l, i1, j1);
            }

            public volatile void write(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                write(jsonwriter, (Calendar)obj);
            }

            public void write(JsonWriter jsonwriter, Calendar calendar)
                throws IOException
            {
                if (calendar == null)
                {
                    jsonwriter.nullValue();
                    return;
                } else
                {
                    jsonwriter.beginObject();
                    jsonwriter.name("year");
                    jsonwriter.value(calendar.get(1));
                    jsonwriter.name("month");
                    jsonwriter.value(calendar.get(2));
                    jsonwriter.name("dayOfMonth");
                    jsonwriter.value(calendar.get(5));
                    jsonwriter.name("hourOfDay");
                    jsonwriter.value(calendar.get(11));
                    jsonwriter.name("minute");
                    jsonwriter.value(calendar.get(12));
                    jsonwriter.name("second");
                    jsonwriter.value(calendar.get(13));
                    jsonwriter.endObject();
                    return;
                }
            }

        };
        CALENDAR_FACTORY = newFactoryForMultipleTypes(java/util/Calendar, java/util/GregorianCalendar, CALENDAR);
        LOCALE = new TypeAdapter() {

            public volatile Object read(JsonReader jsonreader)
                throws IOException
            {
                return read(jsonreader);
            }

            public Locale read(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                }
                StringTokenizer stringtokenizer = new StringTokenizer(jsonreader.nextString(), "_");
                boolean flag = stringtokenizer.hasMoreElements();
                String s = null;
                if (flag)
                {
                    s = stringtokenizer.nextToken();
                }
                boolean flag1 = stringtokenizer.hasMoreElements();
                String s1 = null;
                if (flag1)
                {
                    s1 = stringtokenizer.nextToken();
                }
                boolean flag2 = stringtokenizer.hasMoreElements();
                String s2 = null;
                if (flag2)
                {
                    s2 = stringtokenizer.nextToken();
                }
                if (s1 == null && s2 == null)
                {
                    return new Locale(s);
                }
                if (s2 == null)
                {
                    return new Locale(s, s1);
                } else
                {
                    return new Locale(s, s1, s2);
                }
            }

            public volatile void write(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                write(jsonwriter, (Locale)obj);
            }

            public void write(JsonWriter jsonwriter, Locale locale)
                throws IOException
            {
                String s;
                if (locale == null)
                {
                    s = null;
                } else
                {
                    s = locale.toString();
                }
                jsonwriter.value(s);
            }

        };
        LOCALE_FACTORY = newFactory(java/util/Locale, LOCALE);
        JSON_ELEMENT = new TypeAdapter() {

            public JsonElement read(JsonReader jsonreader)
                throws IOException
            {
                JsonObject jsonobject;
                switch (_cls32..SwitchMap.com.google.gson.stream.JsonToken[jsonreader.peek().ordinal()])
                {
                default:
                    throw new IllegalArgumentException();

                case 3: // '\003'
                    return new JsonPrimitive(jsonreader.nextString());

                case 1: // '\001'
                    return new JsonPrimitive(new LazilyParsedNumber(jsonreader.nextString()));

                case 2: // '\002'
                    return new JsonPrimitive(Boolean.valueOf(jsonreader.nextBoolean()));

                case 4: // '\004'
                    jsonreader.nextNull();
                    return JsonNull.INSTANCE;

                case 5: // '\005'
                    JsonArray jsonarray = new JsonArray();
                    jsonreader.beginArray();
                    for (; jsonreader.hasNext(); jsonarray.add(read(jsonreader))) { }
                    jsonreader.endArray();
                    return jsonarray;

                case 6: // '\006'
                    jsonobject = new JsonObject();
                    jsonreader.beginObject();
                    break;
                }
                for (; jsonreader.hasNext(); jsonobject.add(jsonreader.nextName(), read(jsonreader))) { }
                jsonreader.endObject();
                return jsonobject;
            }

            public volatile Object read(JsonReader jsonreader)
                throws IOException
            {
                return read(jsonreader);
            }

            public void write(JsonWriter jsonwriter, JsonElement jsonelement)
                throws IOException
            {
                if (jsonelement == null || jsonelement.isJsonNull())
                {
                    jsonwriter.nullValue();
                    return;
                }
                if (jsonelement.isJsonPrimitive())
                {
                    JsonPrimitive jsonprimitive = jsonelement.getAsJsonPrimitive();
                    if (jsonprimitive.isNumber())
                    {
                        jsonwriter.value(jsonprimitive.getAsNumber());
                        return;
                    }
                    if (jsonprimitive.isBoolean())
                    {
                        jsonwriter.value(jsonprimitive.getAsBoolean());
                        return;
                    } else
                    {
                        jsonwriter.value(jsonprimitive.getAsString());
                        return;
                    }
                }
                if (jsonelement.isJsonArray())
                {
                    jsonwriter.beginArray();
                    for (Iterator iterator1 = jsonelement.getAsJsonArray().iterator(); iterator1.hasNext(); write(jsonwriter, (JsonElement)iterator1.next())) { }
                    jsonwriter.endArray();
                    return;
                }
                if (jsonelement.isJsonObject())
                {
                    jsonwriter.beginObject();
                    java.util.Map.Entry entry;
                    for (Iterator iterator = jsonelement.getAsJsonObject().entrySet().iterator(); iterator.hasNext(); write(jsonwriter, (JsonElement)entry.getValue()))
                    {
                        entry = (java.util.Map.Entry)iterator.next();
                        jsonwriter.name((String)entry.getKey());
                    }

                    jsonwriter.endObject();
                    return;
                } else
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Couldn't write ").append(jsonelement.getClass()).toString());
                }
            }

            public volatile void write(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                write(jsonwriter, (JsonElement)obj);
            }

        };
        JSON_ELEMENT_FACTORY = newFactory(com/google/gson/JsonElement, JSON_ELEMENT);
    }
}
