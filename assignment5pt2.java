import java.util.HashMap;
import java.util.Map;

class Data {
    String type;
    Object content;

    public Data(String type, Object content) {
        this.type = type;
        this.content = content;
    }
}

abstract class DataProcessor {
    public abstract void process(Data data);
}

class TextDataProcessor extends DataProcessor {
    public void process(Data data) {
        System.out.println("Processing text data: " + data.content);
        // Processing logic for text data
    }
}

class AudioDataProcessor extends DataProcessor {
    public void process(Data data) {
        System.out.println("Processing audio data: " + data.content);
        // Processing logic for audio data
    }
}

class VideoDataProcessor extends DataProcessor {
    public void process(Data data) {
        System.out.println("Processing video data: " + data.content);
        // Processing logic for video data
    }
}

class DataProcessorCreator {
    private Map<String, DataProcessor> processors = new HashMap<>();

    public void setProcessor(String type, DataProcessor processor) {
        processors.put(type, processor);
    }

    public void processData(Data data) {
        DataProcessor processor = processors.get(data.type);
        if (processor != null) {
            processor.process(data);
        } else {
            System.out.println("No processor found for data type: " + data.type);
        }
    }
}

class NewDataTypeProcessor extends DataProcessor {
    public void process(Data data) {
        System.out.println("Processing new data type: " + data.content);
        // Processing logic for the new data type
    }
}

public class assignment5pt2 {
    public static void main(String[] args) {
        DataProcessorCreator creator = new DataProcessorCreator();

        TextDataProcessor textProcessor = new TextDataProcessor();
        creator.setProcessor("text", textProcessor);

        AudioDataProcessor audioProcessor = new AudioDataProcessor();
        creator.setProcessor("audio", audioProcessor);

        VideoDataProcessor videoProcessor = new VideoDataProcessor();
        creator.setProcessor("video", videoProcessor);

        NewDataTypeProcessor newDataTypeProcessor = new NewDataTypeProcessor();
        creator.setProcessor("newDataType", newDataTypeProcessor);

        Data textData = new Data("text", "Sample text data");
        Data audioData = new Data("audio", "Sample audio data");
        Data videoData = new Data("video", "Sample video data");
        Data newData = new Data("newDataType", "Sample new data");

        creator.processData(textData);
        creator.processData(audioData);
        creator.processData(videoData);
        creator.processData(newData);
    }
}
