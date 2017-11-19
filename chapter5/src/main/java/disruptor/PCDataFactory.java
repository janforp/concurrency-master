package disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by Janita on 2017/11/18- 11:43
 * 该类是:
 */
public class PCDataFactory implements EventFactory<PCData>{

    @Override
    public PCData newInstance() {
        return new PCData();
    }
}