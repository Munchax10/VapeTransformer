import skid.nullable.vapetransformer.VapeTransformer;
import skid.nullable.vapetransformer.transformers.RenameTransformer;
import skid.nullable.vapetransformer.transformers.base.Transformer;

public class Main {

    // List of transformers used
    public final static Transformer[] transformers = new Transformer[] {
            new RenameTransformer(),
    };

    public static void main(String[] args) {
        VapeTransformer transformer = new VapeTransformer();
        transformer.run(args, transformers);
    }
}