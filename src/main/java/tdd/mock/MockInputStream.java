package tdd.mock;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.junit.Test;
import org.mockito.Mockito;

public class MockInputStream {
  
  @Test(expected = IOException.class)
  public void testForIOException() throws Exception {
      // 创建并配置 mock 对象
      OutputStream mockStream = Mockito.mock(OutputStream.class);
      Mockito.doThrow(new IOException()).when(mockStream).close();

      // 使用 mock
      OutputStreamWriter streamWriter = new OutputStreamWriter(mockStream);
      streamWriter.close();
  }
  
}
