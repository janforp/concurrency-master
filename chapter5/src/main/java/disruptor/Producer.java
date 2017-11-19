package disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * Created by Janita on 2017/11/18- 11:44
 * 该类是:
 */
public class Producer  {
    private final RingBuffer<PCData> ringBuffer;

    public Producer(RingBuffer<PCData> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void pushData(ByteBuffer bb) {
        long sequence = ringBuffer.next();
        try {
            PCData event = ringBuffer.get(sequence);
            event.set(bb.getLong(0));
        }finally {
            ringBuffer.publish(sequence);
        }
    }
}
