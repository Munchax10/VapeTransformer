package skid.nullable.vapetransformer;

import skid.nullable.vapetransformer.transformers.base.Transformer;

public class VapeTransformer {

    public void run(String[] args, Transformer[] transformers) {
        for (Transformer transformer : transformers) {
            transformer.execute();
        }
    }
}
