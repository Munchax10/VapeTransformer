import skid.nullable.vapetransformer.VapeTransformer;
import skid.nullable.vapetransformer.transformers.DuplicateRemover;
import skid.nullable.vapetransformer.transformers.RenameTransformer;
import skid.nullable.vapetransformer.transformers.base.Transformer;

public class Main {

    // List of transformers used
    public final static Transformer[] transformers = new Transformer[] {
            new RenameTransformer(),
            new DuplicateRemover(),
    };

    public static void main(String[] args) {
        VapeTransformer transformer = new VapeTransformer();
        transformer.run(args, transformers);
    }
}