import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TransactionsFileWriter {
    String filePath;

    public TransactionsFileWriter(String filePath) throws IOException {
        this.filePath = filePath;
        File file  =new File(filePath);

        // Create new file
        if(file.exists()){
            if(file.delete()){
                file.createNewFile();
            }
        }
        else{
            file.createNewFile();
        }
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void write(Transaction transaction) throws IOException{
        try(FileWriter fileWriter = new FileWriter(new File(filePath), true)){
            fileWriter.append(transaction.parseTransaction());
            fileWriter.append("\n");
        }
        catch(Exception exception){
            throw exception;
        }
    }

    public void write(List<Transaction> transactions) throws IOException {
        for(Transaction transaction : transactions){
            write(transaction);
        }
    }
}
