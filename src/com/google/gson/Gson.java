// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.gson:
//            FieldNamingPolicy, LongSerializationPolicy, JsonIOException, JsonSyntaxException, 
//            TypeAdapter, TypeAdapterFactory, JsonDeserializationContext, JsonSerializationContext, 
//            FieldNamingStrategy

public final class Gson
{
    static class FutureTypeAdapter extends TypeAdapter
    {

        private TypeAdapter _flddelegate;

        public Object read(JsonReader jsonreader)
            throws IOException
        {
            if (_flddelegate == null)
            {
                throw new IllegalStateException();
            } else
            {
                return _flddelegate.read(jsonreader);
            }
        }

        public void setDelegate(TypeAdapter typeadapter)
        {
            if (_flddelegate != null)
            {
                throw new AssertionError();
            } else
            {
                _flddelegate = typeadapter;
                return;
            }
        }

        public void write(JsonWriter jsonwriter, Object obj)
            throws IOException
        {
            if (_flddelegate == null)
            {
                throw new IllegalStateException();
            } else
            {
                _flddelegate.write(jsonwriter, obj);
                return;
            }
        }

        FutureTypeAdapter()
        {
        }
    }


    private final ThreadLocal calls;
    private final ConstructorConstructor constructorConstructor;
    final JsonDeserializationContext deserializationContext;
    private final List factories;
    private final boolean generateNonExecutableJson;
    private final boolean htmlSafe;
    private final boolean prettyPrinting;
    final JsonSerializationContext serializationContext;
    private final boolean serializeNulls;
    private final Map typeTokenCache;

    public Gson()
    {
        this(Excluder.DEFAULT, ((FieldNamingStrategy) (FieldNamingPolicy.IDENTITY)), Collections.emptyMap(), false, false, false, true, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    Gson(Excluder excluder, FieldNamingStrategy fieldnamingstrategy, Map map, boolean flag, boolean flag1, boolean flag2, boolean flag3, 
            boolean flag4, boolean flag5, LongSerializationPolicy longserializationpolicy, List list)
    {
        calls = new ThreadLocal() {

            final Gson this$0;

            protected volatile Object initialValue()
            {
                return initialValue();
            }

            protected Map initialValue()
            {
                return new HashMap();
            }

            
            {
                this$0 = Gson.this;
                super();
            }
        };
        typeTokenCache = Collections.synchronizedMap(new HashMap());
        deserializationContext = new JsonDeserializationContext() {

            final Gson this$0;

            
            {
                this$0 = Gson.this;
                super();
            }
        };
        serializationContext = new JsonSerializationContext() {

            final Gson this$0;

            
            {
                this$0 = Gson.this;
                super();
            }
        };
        constructorConstructor = new ConstructorConstructor(map);
        serializeNulls = flag;
        generateNonExecutableJson = flag2;
        htmlSafe = flag3;
        prettyPrinting = flag4;
        ArrayList arraylist = new ArrayList();
        arraylist.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        arraylist.add(ObjectTypeAdapter.FACTORY);
        arraylist.addAll(list);
        arraylist.add(TypeAdapters.STRING_FACTORY);
        arraylist.add(TypeAdapters.INTEGER_FACTORY);
        arraylist.add(TypeAdapters.BOOLEAN_FACTORY);
        arraylist.add(TypeAdapters.BYTE_FACTORY);
        arraylist.add(TypeAdapters.SHORT_FACTORY);
        arraylist.add(TypeAdapters.newFactory(Long.TYPE, java/lang/Long, longAdapter(longserializationpolicy)));
        arraylist.add(TypeAdapters.newFactory(Double.TYPE, java/lang/Double, doubleAdapter(flag5)));
        arraylist.add(TypeAdapters.newFactory(Float.TYPE, java/lang/Float, floatAdapter(flag5)));
        arraylist.add(TypeAdapters.NUMBER_FACTORY);
        arraylist.add(TypeAdapters.CHARACTER_FACTORY);
        arraylist.add(TypeAdapters.STRING_BUILDER_FACTORY);
        arraylist.add(TypeAdapters.STRING_BUFFER_FACTORY);
        arraylist.add(TypeAdapters.newFactory(java/math/BigDecimal, TypeAdapters.BIG_DECIMAL));
        arraylist.add(TypeAdapters.newFactory(java/math/BigInteger, TypeAdapters.BIG_INTEGER));
        arraylist.add(TypeAdapters.URL_FACTORY);
        arraylist.add(TypeAdapters.URI_FACTORY);
        arraylist.add(TypeAdapters.UUID_FACTORY);
        arraylist.add(TypeAdapters.LOCALE_FACTORY);
        arraylist.add(TypeAdapters.INET_ADDRESS_FACTORY);
        arraylist.add(TypeAdapters.BIT_SET_FACTORY);
        arraylist.add(DateTypeAdapter.FACTORY);
        arraylist.add(TypeAdapters.CALENDAR_FACTORY);
        arraylist.add(TimeTypeAdapter.FACTORY);
        arraylist.add(SqlDateTypeAdapter.FACTORY);
        arraylist.add(TypeAdapters.TIMESTAMP_FACTORY);
        arraylist.add(ArrayTypeAdapter.FACTORY);
        arraylist.add(TypeAdapters.ENUM_FACTORY);
        arraylist.add(TypeAdapters.CLASS_FACTORY);
        arraylist.add(excluder);
        arraylist.add(new CollectionTypeAdapterFactory(constructorConstructor));
        arraylist.add(new MapTypeAdapterFactory(constructorConstructor, flag1));
        arraylist.add(new ReflectiveTypeAdapterFactory(constructorConstructor, fieldnamingstrategy, excluder));
        factories = Collections.unmodifiableList(arraylist);
    }

    private static void assertFullConsumption(Object obj, JsonReader jsonreader)
    {
        if (obj != null)
        {
            try
            {
                if (jsonreader.peek() != JsonToken.END_DOCUMENT)
                {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            }
            catch (MalformedJsonException malformedjsonexception)
            {
                throw new JsonSyntaxException(malformedjsonexception);
            }
            catch (IOException ioexception)
            {
                throw new JsonIOException(ioexception);
            }
        }
    }

    private void checkValidFloatingPoint(double d)
    {
        if (Double.isNaN(d) || Double.isInfinite(d))
        {
            throw new IllegalArgumentException((new StringBuilder()).append(d).append(" is not a valid double value as per JSON specification. To override this").append(" behavior, use GsonBuilder.serializeSpecialDoubleValues() method.").toString());
        } else
        {
            return;
        }
    }

    private TypeAdapter doubleAdapter(boolean flag)
    {
        if (flag)
        {
            return TypeAdapters.DOUBLE;
        } else
        {
            return new TypeAdapter() {

                final Gson this$0;

                public Double read(JsonReader jsonreader)
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
                    if (number == null)
                    {
                        jsonwriter.nullValue();
                        return;
                    } else
                    {
                        double d = number.doubleValue();
                        checkValidFloatingPoint(d);
                        jsonwriter.value(number);
                        return;
                    }
                }

                public volatile void write(JsonWriter jsonwriter, Object obj)
                    throws IOException
                {
                    write(jsonwriter, (Number)obj);
                }

            
            {
                this$0 = Gson.this;
                super();
            }
            };
        }
    }

    private TypeAdapter floatAdapter(boolean flag)
    {
        if (flag)
        {
            return TypeAdapters.FLOAT;
        } else
        {
            return new TypeAdapter() {

                final Gson this$0;

                public Float read(JsonReader jsonreader)
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
                    if (number == null)
                    {
                        jsonwriter.nullValue();
                        return;
                    } else
                    {
                        float f = number.floatValue();
                        checkValidFloatingPoint(f);
                        jsonwriter.value(number);
                        return;
                    }
                }

                public volatile void write(JsonWriter jsonwriter, Object obj)
                    throws IOException
                {
                    write(jsonwriter, (Number)obj);
                }

            
            {
                this$0 = Gson.this;
                super();
            }
            };
        }
    }

    private TypeAdapter longAdapter(LongSerializationPolicy longserializationpolicy)
    {
        if (longserializationpolicy == LongSerializationPolicy.DEFAULT)
        {
            return TypeAdapters.LONG;
        } else
        {
            return new TypeAdapter() {

                final Gson this$0;

                public Number read(JsonReader jsonreader)
                    throws IOException
                {
                    if (jsonreader.peek() == JsonToken.NULL)
                    {
                        jsonreader.nextNull();
                        return null;
                    } else
                    {
                        return Long.valueOf(jsonreader.nextLong());
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
                    if (number == null)
                    {
                        jsonwriter.nullValue();
                        return;
                    } else
                    {
                        jsonwriter.value(number.toString());
                        return;
                    }
                }

                public volatile void write(JsonWriter jsonwriter, Object obj)
                    throws IOException
                {
                    write(jsonwriter, (Number)obj);
                }

            
            {
                this$0 = Gson.this;
                super();
            }
            };
        }
    }

    public Object fromJson(JsonReader jsonreader, Type type)
        throws JsonIOException, JsonSyntaxException
    {
        boolean flag;
        boolean flag1;
        flag = true;
        flag1 = jsonreader.isLenient();
        jsonreader.setLenient(true);
        jsonreader.peek();
        flag = false;
        Object obj = getAdapter(TypeToken.get(type)).read(jsonreader);
        jsonreader.setLenient(flag1);
        return obj;
        EOFException eofexception;
        eofexception;
        if (flag)
        {
            jsonreader.setLenient(flag1);
            return null;
        }
        throw new JsonSyntaxException(eofexception);
        Exception exception;
        exception;
        jsonreader.setLenient(flag1);
        throw exception;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        throw new JsonSyntaxException(illegalstateexception);
        IOException ioexception;
        ioexception;
        throw new JsonSyntaxException(ioexception);
    }

    public Object fromJson(Reader reader, Type type)
        throws JsonIOException, JsonSyntaxException
    {
        JsonReader jsonreader = new JsonReader(reader);
        Object obj = fromJson(jsonreader, type);
        assertFullConsumption(obj, jsonreader);
        return obj;
    }

    public Object fromJson(String s, Class class1)
        throws JsonSyntaxException
    {
        Object obj = fromJson(s, ((Type) (class1)));
        return Primitives.wrap(class1).cast(obj);
    }

    public Object fromJson(String s, Type type)
        throws JsonSyntaxException
    {
        if (s == null)
        {
            return null;
        } else
        {
            return fromJson(((Reader) (new StringReader(s))), type);
        }
    }

    public TypeAdapter getAdapter(TypeToken typetoken)
    {
        Map map;
        FutureTypeAdapter futuretypeadapter1;
        TypeAdapter typeadapter = (TypeAdapter)typeTokenCache.get(typetoken);
        if (typeadapter != null)
        {
            return typeadapter;
        }
        map = (Map)calls.get();
        FutureTypeAdapter futuretypeadapter = (FutureTypeAdapter)map.get(typetoken);
        if (futuretypeadapter != null)
        {
            return futuretypeadapter;
        }
        futuretypeadapter1 = new FutureTypeAdapter();
        map.put(typetoken, futuretypeadapter1);
        Iterator iterator = factories.iterator();
        TypeAdapter typeadapter1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_146;
            }
            typeadapter1 = ((TypeAdapterFactory)iterator.next()).create(this, typetoken);
        } while (typeadapter1 == null);
        futuretypeadapter1.setDelegate(typeadapter1);
        typeTokenCache.put(typetoken, typeadapter1);
        map.remove(typetoken);
        return typeadapter1;
        throw new IllegalArgumentException((new StringBuilder()).append("GSON cannot handle ").append(typetoken).toString());
        Exception exception;
        exception;
        map.remove(typetoken);
        throw exception;
    }

    public TypeAdapter getAdapter(Class class1)
    {
        return getAdapter(TypeToken.get(class1));
    }

    public TypeAdapter getDelegateAdapter(TypeAdapterFactory typeadapterfactory, TypeToken typetoken)
    {
        boolean flag = false;
        for (Iterator iterator = factories.iterator(); iterator.hasNext();)
        {
            TypeAdapterFactory typeadapterfactory1 = (TypeAdapterFactory)iterator.next();
            if (!flag)
            {
                if (typeadapterfactory1 == typeadapterfactory)
                {
                    flag = true;
                }
            } else
            {
                TypeAdapter typeadapter = typeadapterfactory1.create(this, typetoken);
                if (typeadapter != null)
                {
                    return typeadapter;
                }
            }
        }

        throw new IllegalArgumentException((new StringBuilder()).append("GSON cannot serialize ").append(typetoken).toString());
    }

    public String toString()
    {
        return (new StringBuilder("{")).append("serializeNulls:").append(serializeNulls).append("factories:").append(factories).append(",instanceCreators:").append(constructorConstructor).append("}").toString();
    }

}
