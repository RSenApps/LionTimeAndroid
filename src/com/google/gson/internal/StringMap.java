// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

public final class StringMap extends AbstractMap
{
    private final class EntrySet extends AbstractSet
    {

        final StringMap this$0;

        public void clear()
        {
            StringMap.this.clear();
        }

        public boolean contains(Object obj)
        {
            if (obj instanceof java.util.Map.Entry)
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)obj;
                Object obj1 = get(entry.getKey());
                if (obj1 != null && obj1.equals(entry.getValue()))
                {
                    return true;
                }
            }
            return false;
        }

        public Iterator iterator()
        {
            return new LinkedHashIterator() {

                final EntrySet this$1;

                public volatile Object next()
                {
                    return next();
                }

                public final java.util.Map.Entry next()
                {
                    return nextEntry();
                }

            
            {
                this$1 = EntrySet.this;
                super();
            }
            };
        }

        public boolean remove(Object obj)
        {
            if (!(obj instanceof java.util.Map.Entry))
            {
                return false;
            } else
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)obj;
                return removeMapping(entry.getKey(), entry.getValue());
            }
        }

        public int size()
        {
            return StringMap.this.size;
        }

        private EntrySet()
        {
            this$0 = StringMap.this;
            super();
        }

    }

    private final class KeySet extends AbstractSet
    {

        final StringMap this$0;

        public void clear()
        {
            StringMap.this.clear();
        }

        public boolean contains(Object obj)
        {
            return containsKey(obj);
        }

        public Iterator iterator()
        {
            return new LinkedHashIterator() {

                final KeySet this$1;

                public volatile Object next()
                {
                    return next();
                }

                public final String next()
                {
                    return nextEntry().key;
                }

            
            {
                this$1 = KeySet.this;
                super();
            }
            };
        }

        public boolean remove(Object obj)
        {
            int i = StringMap.this.size;
            StringMap.this.remove(obj);
            return StringMap.this.size != i;
        }

        public int size()
        {
            return StringMap.this.size;
        }

        private KeySet()
        {
            this$0 = StringMap.this;
            super();
        }

    }

    static class LinkedEntry
        implements java.util.Map.Entry
    {

        final int hash;
        final String key;
        LinkedEntry next;
        LinkedEntry nxt;
        LinkedEntry prv;
        Object value;

        public final boolean equals(Object obj)
        {
            if (obj instanceof java.util.Map.Entry)
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)obj;
                Object obj1 = entry.getValue();
                if (key.equals(entry.getKey()) && (value != null ? value.equals(obj1) : obj1 == null))
                {
                    return true;
                }
            }
            return false;
        }

        public volatile Object getKey()
        {
            return getKey();
        }

        public final String getKey()
        {
            return key;
        }

        public final Object getValue()
        {
            return value;
        }

        public final int hashCode()
        {
            int i;
            Object obj;
            int j;
            if (key == null)
            {
                i = 0;
            } else
            {
                i = key.hashCode();
            }
            obj = value;
            j = 0;
            if (obj != null)
            {
                j = value.hashCode();
            }
            return i ^ j;
        }

        public final Object setValue(Object obj)
        {
            Object obj1 = value;
            value = obj;
            return obj1;
        }

        public final String toString()
        {
            return (new StringBuilder()).append(key).append("=").append(value).toString();
        }

        LinkedEntry()
        {
            this(null, null, 0, null, null, null);
            prv = this;
            nxt = this;
        }

        LinkedEntry(String s, Object obj, int i, LinkedEntry linkedentry, LinkedEntry linkedentry1, LinkedEntry linkedentry2)
        {
            key = s;
            value = obj;
            hash = i;
            next = linkedentry;
            nxt = linkedentry1;
            prv = linkedentry2;
        }
    }

    private abstract class LinkedHashIterator
        implements Iterator
    {

        LinkedEntry lastReturned;
        LinkedEntry next;
        final StringMap this$0;

        public final boolean hasNext()
        {
            return next != header;
        }

        final LinkedEntry nextEntry()
        {
            LinkedEntry linkedentry = next;
            if (linkedentry == header)
            {
                throw new NoSuchElementException();
            } else
            {
                next = linkedentry.nxt;
                lastReturned = linkedentry;
                return linkedentry;
            }
        }

        public final void remove()
        {
            if (lastReturned == null)
            {
                throw new IllegalStateException();
            } else
            {
                StringMap.this.remove(lastReturned.key);
                lastReturned = null;
                return;
            }
        }

        private LinkedHashIterator()
        {
            this$0 = StringMap.this;
            super();
            next = header.nxt;
            lastReturned = null;
        }

    }

    private final class Values extends AbstractCollection
    {

        final StringMap this$0;

        public void clear()
        {
            StringMap.this.clear();
        }

        public boolean contains(Object obj)
        {
            return containsValue(obj);
        }

        public Iterator iterator()
        {
            return new LinkedHashIterator() {

                final Values this$1;

                public final Object next()
                {
                    return nextEntry().value;
                }

            
            {
                this$1 = Values.this;
                super();
            }
            };
        }

        public int size()
        {
            return StringMap.this.size;
        }

        private Values()
        {
            this$0 = StringMap.this;
            super();
        }

    }


    private static final java.util.Map.Entry EMPTY_TABLE[] = new LinkedEntry[2];
    private static final int seed = (new Random()).nextInt();
    private Set entrySet;
    private LinkedEntry header;
    private Set keySet;
    private int size;
    private LinkedEntry table[];
    private int threshold;
    private Collection values;

    public StringMap()
    {
        table = (LinkedEntry[])(LinkedEntry[])EMPTY_TABLE;
        threshold = -1;
        header = new LinkedEntry();
    }

    private void addNewEntry(String s, Object obj, int i, int j)
    {
        LinkedEntry linkedentry = header;
        LinkedEntry linkedentry1 = linkedentry.prv;
        LinkedEntry linkedentry2 = new LinkedEntry(s, obj, i, table[j], linkedentry, linkedentry1);
        LinkedEntry alinkedentry[] = table;
        linkedentry.prv = linkedentry2;
        linkedentry1.nxt = linkedentry2;
        alinkedentry[j] = linkedentry2;
    }

    private LinkedEntry[] doubleCapacity()
    {
        LinkedEntry alinkedentry[] = table;
        int i = alinkedentry.length;
        LinkedEntry alinkedentry1[];
        if (i == 0x40000000)
        {
            alinkedentry1 = alinkedentry;
        } else
        {
            alinkedentry1 = makeTable(i * 2);
            if (size != 0)
            {
                int j = 0;
                while (j < i) 
                {
                    LinkedEntry linkedentry = alinkedentry[j];
                    if (linkedentry != null)
                    {
                        int k = i & linkedentry.hash;
                        LinkedEntry linkedentry1 = null;
                        alinkedentry1[j | k] = linkedentry;
                        LinkedEntry linkedentry2 = linkedentry.next;
                        while (linkedentry2 != null) 
                        {
                            int l = i & linkedentry2.hash;
                            if (l != k)
                            {
                                if (linkedentry1 == null)
                                {
                                    alinkedentry1[j | l] = linkedentry2;
                                } else
                                {
                                    linkedentry1.next = linkedentry2;
                                }
                                linkedentry1 = linkedentry;
                                k = l;
                            }
                            linkedentry = linkedentry2;
                            linkedentry2 = linkedentry2.next;
                        }
                        if (linkedentry1 != null)
                        {
                            linkedentry1.next = null;
                        }
                    }
                    j++;
                }
            }
        }
        return alinkedentry1;
    }

    private LinkedEntry getEntry(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        LinkedEntry linkedentry = null;
_L4:
        return linkedentry;
_L2:
        int i = hash(s);
        LinkedEntry alinkedentry[] = table;
        linkedentry = alinkedentry[i & -1 + alinkedentry.length];
label0:
        do
        {
label1:
            {
                if (linkedentry == null)
                {
                    break label1;
                }
                String s1 = linkedentry.key;
                if (s1 == s || linkedentry.hash == i && s.equals(s1))
                {
                    break label0;
                }
                linkedentry = linkedentry.next;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return null;
    }

    private static int hash(String s)
    {
        int i = seed;
        for (int j = 0; j < s.length(); j++)
        {
            int l = i + s.charAt(j);
            int i1 = l + l << 10;
            i = i1 ^ i1 >>> 6;
        }

        int k = i ^ (i >>> 20 ^ i >>> 12);
        return k ^ k >>> 7 ^ k >>> 4;
    }

    private LinkedEntry[] makeTable(int i)
    {
        LinkedEntry alinkedentry[] = (LinkedEntry[])new LinkedEntry[i];
        table = alinkedentry;
        threshold = (i >> 1) + (i >> 2);
        return alinkedentry;
    }

    private boolean removeMapping(Object obj, Object obj1)
    {
        if (obj == null || !(obj instanceof String))
        {
            return false;
        }
        int i = hash((String)obj);
        LinkedEntry alinkedentry[] = table;
        int j = i & -1 + alinkedentry.length;
        LinkedEntry linkedentry = alinkedentry[j];
        LinkedEntry linkedentry1 = null;
        for (; linkedentry != null; linkedentry = linkedentry.next)
        {
            if (linkedentry.hash == i && obj.equals(linkedentry.key))
            {
                if (obj1 != null ? !obj1.equals(linkedentry.value) : linkedentry.value != null)
                {
                    return false;
                }
                if (linkedentry1 == null)
                {
                    alinkedentry[j] = linkedentry.next;
                } else
                {
                    linkedentry1.next = linkedentry.next;
                }
                size = -1 + size;
                unlink(linkedentry);
                return true;
            }
            linkedentry1 = linkedentry;
        }

        return false;
    }

    private void unlink(LinkedEntry linkedentry)
    {
        linkedentry.prv.nxt = linkedentry.nxt;
        linkedentry.nxt.prv = linkedentry.prv;
        linkedentry.prv = null;
        linkedentry.nxt = null;
    }

    public void clear()
    {
        if (size != 0)
        {
            Arrays.fill(table, null);
            size = 0;
        }
        LinkedEntry linkedentry = header;
        LinkedEntry linkedentry2;
        for (LinkedEntry linkedentry1 = linkedentry.nxt; linkedentry1 != linkedentry; linkedentry1 = linkedentry2)
        {
            linkedentry2 = linkedentry1.nxt;
            linkedentry1.prv = null;
            linkedentry1.nxt = null;
        }

        linkedentry.prv = linkedentry;
        linkedentry.nxt = linkedentry;
    }

    public boolean containsKey(Object obj)
    {
        return (obj instanceof String) && getEntry((String)obj) != null;
    }

    public Set entrySet()
    {
        Set set = entrySet;
        if (set != null)
        {
            return set;
        } else
        {
            EntrySet entryset = new EntrySet();
            entrySet = entryset;
            return entryset;
        }
    }

    public Object get(Object obj)
    {
        boolean flag = obj instanceof String;
        Object obj1 = null;
        if (flag)
        {
            LinkedEntry linkedentry = getEntry((String)obj);
            obj1 = null;
            if (linkedentry != null)
            {
                obj1 = linkedentry.value;
            }
        }
        return obj1;
    }

    public Set keySet()
    {
        Set set = keySet;
        if (set != null)
        {
            return set;
        } else
        {
            KeySet keyset = new KeySet();
            keySet = keyset;
            return keyset;
        }
    }

    public volatile Object put(Object obj, Object obj1)
    {
        return put((String)obj, obj1);
    }

    public Object put(String s, Object obj)
    {
        if (s == null)
        {
            throw new NullPointerException("key == null");
        }
        int i = hash(s);
        LinkedEntry alinkedentry[] = table;
        int j = i & -1 + alinkedentry.length;
        for (LinkedEntry linkedentry = alinkedentry[j]; linkedentry != null; linkedentry = linkedentry.next)
        {
            if (linkedentry.hash == i && s.equals(linkedentry.key))
            {
                Object obj1 = linkedentry.value;
                linkedentry.value = obj;
                return obj1;
            }
        }

        int k = size;
        size = k + 1;
        if (k > threshold)
        {
            j = i & -1 + doubleCapacity().length;
        }
        addNewEntry(s, obj, i, j);
        return null;
    }

    public Object remove(Object obj)
    {
        if (obj == null || !(obj instanceof String))
        {
            return null;
        }
        int i = hash((String)obj);
        LinkedEntry alinkedentry[] = table;
        int j = i & -1 + alinkedentry.length;
        LinkedEntry linkedentry = alinkedentry[j];
        LinkedEntry linkedentry1 = null;
        for (; linkedentry != null; linkedentry = linkedentry.next)
        {
            if (linkedentry.hash == i && obj.equals(linkedentry.key))
            {
                if (linkedentry1 == null)
                {
                    alinkedentry[j] = linkedentry.next;
                } else
                {
                    linkedentry1.next = linkedentry.next;
                }
                size = -1 + size;
                unlink(linkedentry);
                return linkedentry.value;
            }
            linkedentry1 = linkedentry;
        }

        return null;
    }

    public int size()
    {
        return size;
    }

    public Collection values()
    {
        Collection collection = values;
        if (collection != null)
        {
            return collection;
        } else
        {
            Values values1 = new Values();
            values = values1;
            return values1;
        }
    }




}
