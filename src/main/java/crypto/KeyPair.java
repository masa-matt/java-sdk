package crypto;

import model.transaction.Signature;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * key pair in IOST
 */
public abstract class KeyPair {

    private String ID;

    /**
     * get this key pair's key id
     * @return - base58 encoded public key
     */
    public String getID() {
        if (this.ID == null) {
            this.ID = Base58.encode(this.pubkey());
        }
        return this.ID;
    }

    /**
     * get public key in base58
     * @return -
     */
    public String B58PubKey() {
        return Base58.encode(this.pubkey());
    }

    /**
     * get private key in base58
     * @return -
     */
    public String B58SecKey() {
        return Base58.encode(this.seckey());
    }

    /**
     * sign to info
     * @param info - 256 bit info
     * @return - Signature
     */
    abstract public Signature sign(byte[] info);
    abstract byte[] pubkey();
    abstract byte[] seckey();
}

