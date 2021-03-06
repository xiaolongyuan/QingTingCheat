package fm.qingting.async.parser;

import fm.qingting.async.DataEmitter;
import fm.qingting.async.DataSink;
import fm.qingting.async.callback.CompletedCallback;
import fm.qingting.async.future.Future;

public abstract interface AsyncParser<T>
{
  public abstract Future<T> parse(DataEmitter paramDataEmitter);

  public abstract void write(DataSink paramDataSink, T paramT, CompletedCallback paramCompletedCallback);
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.async.parser.AsyncParser
 * JD-Core Version:    0.6.2
 */