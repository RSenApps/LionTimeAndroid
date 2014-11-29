// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Excluder
    implements TypeAdapterFactory, Cloneable
{

    public static final Excluder DEFAULT = new Excluder();
    private List deserializationStrategies;
    private int modifiers;
    private boolean requireExpose;
    private List serializationStrategies;
    private boolean serializeInnerClasses;
    private double version;

    public Excluder()
    {
        version = -1D;
        modifiers = 136;
        serializeInnerClasses = true;
        serializationStrategies = Collections.emptyList();
        deserializationStrategies = Collections.emptyList();
    }

    private boolean isAnonymousOrLocal(Class class1)
    {
        return !java/lang/Enum.isAssignableFrom(class1) && (class1.isAnonymousClass() || class1.isLocalClass());
    }

    private boolean isInnerClass(Class class1)
    {
        return class1.isMemberClass() && !isStatic(class1);
    }

    private boolean isStatic(Class class1)
    {
        return (8 & class1.getModifiers()) != 0;
    }

    private boolean isValidSince(Since since)
    {
        return since == null || since.value() <= version;
    }

    private boolean isValidUntil(Until until)
    {
        return until == null || until.value() > version;
    }

    private boolean isValidVersion(Since since, Until until)
    {
        return isValidSince(since) && isValidUntil(until);
    }

    protected Excluder clone()
    {
        Excluder excluder;
        try
        {
            excluder = (Excluder)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError();
        }
        return excluder;
    }

    protected volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public TypeAdapter create(final Gson gson, final TypeToken type)
    {
        Class class1 = type.getRawType();
        final boolean skipSerialize = excludeClass(class1, true);
        final boolean skipDeserialize = excludeClass(class1, false);
        if (!skipSerialize && !skipDeserialize)
        {
            return null;
        } else
        {
            return new TypeAdapter() {

                private TypeAdapter _flddelegate;
                final Excluder this$0;
                final Gson val$gson;
                final boolean val$skipDeserialize;
                final boolean val$skipSerialize;
                final TypeToken val$type;

                private TypeAdapter _mthdelegate()
                {
                    TypeAdapter typeadapter = _flddelegate;
                    if (typeadapter != null)
                    {
                        return typeadapter;
                    } else
                    {
                        TypeAdapter typeadapter1 = gson.getDelegateAdapter(Excluder.this, type);
                        _flddelegate = typeadapter1;
                        return typeadapter1;
                    }
                }

                public Object read(JsonReader jsonreader)
                    throws IOException
                {
                    if (skipDeserialize)
                    {
                        jsonreader.skipValue();
                        return null;
                    } else
                    {
                        return _mthdelegate().read(jsonreader);
                    }
                }

                public void write(JsonWriter jsonwriter, Object obj)
                    throws IOException
                {
                    if (skipSerialize)
                    {
                        jsonwriter.nullValue();
                        return;
                    } else
                    {
                        _mthdelegate().write(jsonwriter, obj);
                        return;
                    }
                }

            
            {
                this$0 = Excluder.this;
                skipDeserialize = flag;
                skipSerialize = flag1;
                gson = gson1;
                type = typetoken;
                super();
            }
            };
        }
    }

    public boolean excludeClass(Class class1, boolean flag)
    {
        if (version != -1D && !isValidVersion((Since)class1.getAnnotation(com/google/gson/annotations/Since), (Until)class1.getAnnotation(com/google/gson/annotations/Until)))
        {
            return true;
        }
        if (!serializeInnerClasses && isInnerClass(class1))
        {
            return true;
        }
        if (isAnonymousOrLocal(class1))
        {
            return true;
        }
        List list;
        Iterator iterator;
        if (flag)
        {
            list = serializationStrategies;
        } else
        {
            list = deserializationStrategies;
        }
        for (iterator = list.iterator(); iterator.hasNext();)
        {
            if (((ExclusionStrategy)iterator.next()).shouldSkipClass(class1))
            {
                return true;
            }
        }

        return false;
    }

    public boolean excludeField(Field field, boolean flag)
    {
label0:
        {
            if ((modifiers & field.getModifiers()) != 0)
            {
                return true;
            }
            if (version != -1D && !isValidVersion((Since)field.getAnnotation(com/google/gson/annotations/Since), (Until)field.getAnnotation(com/google/gson/annotations/Until)))
            {
                return true;
            }
            if (field.isSynthetic())
            {
                return true;
            }
            if (requireExpose)
            {
                Expose expose = (Expose)field.getAnnotation(com/google/gson/annotations/Expose);
                if (expose == null || (flag ? !expose.serialize() : !expose.deserialize()))
                {
                    return true;
                }
            }
            if (!serializeInnerClasses && isInnerClass(field.getType()))
            {
                return true;
            }
            if (isAnonymousOrLocal(field.getType()))
            {
                return true;
            }
            List list;
            FieldAttributes fieldattributes;
            Iterator iterator;
            if (flag)
            {
                list = serializationStrategies;
            } else
            {
                list = deserializationStrategies;
            }
            if (list.isEmpty())
            {
                break label0;
            }
            fieldattributes = new FieldAttributes(field);
            iterator = list.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (!((ExclusionStrategy)iterator.next()).shouldSkipField(fieldattributes));
            return true;
        }
        return false;
    }

}
