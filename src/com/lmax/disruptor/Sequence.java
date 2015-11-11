package com.lmax.disruptor;

import com.lmax.disruptor.util.Util;
import sun.misc.Unsafe;

public class Sequence
{
  private static final Unsafe unsafe = Util.getUnsafe();
  private static final long valueOffset = unsafe.arrayBaseOffset([J.class) + 7 * unsafe.arrayIndexScale([J.class);
  private final long[] paddedValue = new long[15];

  public Sequence()
  {
    setOrdered(-1L);
  }

  public Sequence(long paramLong)
  {
    setOrdered(paramLong);
  }

  private void setOrdered(long paramLong)
  {
    unsafe.putLongVolatile(this.paddedValue, valueOffset, paramLong);
  }

  public long addAndGet(long paramLong)
  {
    long l1;
    long l2;
    do
    {
      l1 = get();
      l2 = l1 + paramLong;
    }
    while (!compareAndSet(l1, l2));
    return l2;
  }

  public boolean compareAndSet(long paramLong1, long paramLong2)
  {
    return unsafe.compareAndSwapLong(this.paddedValue, valueOffset, paramLong1, paramLong2);
  }

  public long get()
  {
    return unsafe.getLongVolatile(this.paddedValue, valueOffset);
  }

  public long incrementAndGet()
  {
    return addAndGet(1L);
  }

  public void set(long paramLong)
  {
    unsafe.putLongVolatile(this.paddedValue, valueOffset, paramLong);
  }

  public String toString()
  {
    return Long.toString(get());
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     com.lmax.disruptor.Sequence
 * JD-Core Version:    0.6.2
 */