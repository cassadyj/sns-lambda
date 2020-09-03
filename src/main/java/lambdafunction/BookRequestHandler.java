package lambdafunction;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Introspected
public class BookRequestHandler extends MicronautRequestHandler<SNSEvent, Long> {
    Logger logger = LoggerFactory.getLogger(BookRequestHandler.class);

    @Override
    public Long execute(SNSEvent input) {
        List<SNSEvent.SNSRecord> records = input.getRecords();
        logger.info("Records no: {}", records.size());
        SNSEvent.SNSRecord snsRecord = records.get(0); // this is empty
        logger.info("Record: {}", snsRecord);
        logger.info("Record Event Source: {}" + snsRecord.getEventSource());
        return 1L;
    }
}
