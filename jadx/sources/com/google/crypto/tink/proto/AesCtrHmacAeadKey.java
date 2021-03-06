package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.AesCtrKey;
import com.google.crypto.tink.proto.HmacKey;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class AesCtrHmacAeadKey extends GeneratedMessageLite<AesCtrHmacAeadKey, Builder> implements AesCtrHmacAeadKeyOrBuilder {
    public static final int AES_CTR_KEY_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final AesCtrHmacAeadKey DEFAULT_INSTANCE;
    public static final int HMAC_KEY_FIELD_NUMBER = 3;
    private static volatile Parser<AesCtrHmacAeadKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private AesCtrKey aesCtrKey_;
    private HmacKey hmacKey_;
    private int version_;

    private AesCtrHmacAeadKey() {
    }

    public int getVersion() {
        return this.version_;
    }

    /* access modifiers changed from: private */
    public void setVersion(int i) {
        this.version_ = i;
    }

    /* access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    public boolean hasAesCtrKey() {
        return this.aesCtrKey_ != null;
    }

    public AesCtrKey getAesCtrKey() {
        AesCtrKey aesCtrKey = this.aesCtrKey_;
        return aesCtrKey == null ? AesCtrKey.getDefaultInstance() : aesCtrKey;
    }

    /* access modifiers changed from: private */
    public void setAesCtrKey(AesCtrKey aesCtrKey) {
        if (aesCtrKey != null) {
            this.aesCtrKey_ = aesCtrKey;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setAesCtrKey(AesCtrKey.Builder builder) {
        this.aesCtrKey_ = (AesCtrKey) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeAesCtrKey(AesCtrKey aesCtrKey) {
        AesCtrKey aesCtrKey2 = this.aesCtrKey_;
        if (aesCtrKey2 == null || aesCtrKey2 == AesCtrKey.getDefaultInstance()) {
            this.aesCtrKey_ = aesCtrKey;
        } else {
            this.aesCtrKey_ = (AesCtrKey) ((AesCtrKey.Builder) AesCtrKey.newBuilder(this.aesCtrKey_).mergeFrom(aesCtrKey)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearAesCtrKey() {
        this.aesCtrKey_ = null;
    }

    public boolean hasHmacKey() {
        return this.hmacKey_ != null;
    }

    public HmacKey getHmacKey() {
        HmacKey hmacKey = this.hmacKey_;
        return hmacKey == null ? HmacKey.getDefaultInstance() : hmacKey;
    }

    /* access modifiers changed from: private */
    public void setHmacKey(HmacKey hmacKey) {
        if (hmacKey != null) {
            this.hmacKey_ = hmacKey;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setHmacKey(HmacKey.Builder builder) {
        this.hmacKey_ = (HmacKey) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeHmacKey(HmacKey hmacKey) {
        HmacKey hmacKey2 = this.hmacKey_;
        if (hmacKey2 == null || hmacKey2 == HmacKey.getDefaultInstance()) {
            this.hmacKey_ = hmacKey;
        } else {
            this.hmacKey_ = (HmacKey) ((HmacKey.Builder) HmacKey.newBuilder(this.hmacKey_).mergeFrom(hmacKey)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearHmacKey() {
        this.hmacKey_ = null;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.version_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        if (this.aesCtrKey_ != null) {
            codedOutputStream.writeMessage(2, getAesCtrKey());
        }
        if (this.hmacKey_ != null) {
            codedOutputStream.writeMessage(3, getHmacKey());
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.version_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        if (this.aesCtrKey_ != null) {
            i2 += CodedOutputStream.computeMessageSize(2, getAesCtrKey());
        }
        if (this.hmacKey_ != null) {
            i2 += CodedOutputStream.computeMessageSize(3, getHmacKey());
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static AesCtrHmacAeadKey parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AesCtrHmacAeadKey parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AesCtrHmacAeadKey parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AesCtrHmacAeadKey parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AesCtrHmacAeadKey parseFrom(InputStream inputStream) throws IOException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AesCtrHmacAeadKey parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AesCtrHmacAeadKey parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AesCtrHmacAeadKey) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AesCtrHmacAeadKey parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AesCtrHmacAeadKey) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AesCtrHmacAeadKey parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AesCtrHmacAeadKey parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(AesCtrHmacAeadKey aesCtrHmacAeadKey) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(aesCtrHmacAeadKey);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesCtrHmacAeadKey, Builder> implements AesCtrHmacAeadKeyOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(AesCtrHmacAeadKey.DEFAULT_INSTANCE);
        }

        public int getVersion() {
            return ((AesCtrHmacAeadKey) this.instance).getVersion();
        }

        public Builder setVersion(int i) {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).setVersion(i);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).clearVersion();
            return this;
        }

        public boolean hasAesCtrKey() {
            return ((AesCtrHmacAeadKey) this.instance).hasAesCtrKey();
        }

        public AesCtrKey getAesCtrKey() {
            return ((AesCtrHmacAeadKey) this.instance).getAesCtrKey();
        }

        public Builder setAesCtrKey(AesCtrKey aesCtrKey) {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).setAesCtrKey(aesCtrKey);
            return this;
        }

        public Builder setAesCtrKey(AesCtrKey.Builder builder) {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).setAesCtrKey(builder);
            return this;
        }

        public Builder mergeAesCtrKey(AesCtrKey aesCtrKey) {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).mergeAesCtrKey(aesCtrKey);
            return this;
        }

        public Builder clearAesCtrKey() {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).clearAesCtrKey();
            return this;
        }

        public boolean hasHmacKey() {
            return ((AesCtrHmacAeadKey) this.instance).hasHmacKey();
        }

        public HmacKey getHmacKey() {
            return ((AesCtrHmacAeadKey) this.instance).getHmacKey();
        }

        public Builder setHmacKey(HmacKey hmacKey) {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).setHmacKey(hmacKey);
            return this;
        }

        public Builder setHmacKey(HmacKey.Builder builder) {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).setHmacKey(builder);
            return this;
        }

        public Builder mergeHmacKey(HmacKey hmacKey) {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).mergeHmacKey(hmacKey);
            return this;
        }

        public Builder clearHmacKey() {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).clearHmacKey();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesCtrHmacAeadKey$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke[] r0 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.VISIT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.AesCtrHmacAeadKey.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        boolean z = false;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new AesCtrHmacAeadKey();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                AesCtrHmacAeadKey aesCtrHmacAeadKey = (AesCtrHmacAeadKey) obj2;
                boolean z2 = this.version_ != 0;
                int i = this.version_;
                if (aesCtrHmacAeadKey.version_ != 0) {
                    z = true;
                }
                this.version_ = visitor.visitInt(z2, i, z, aesCtrHmacAeadKey.version_);
                this.aesCtrKey_ = (AesCtrKey) visitor.visitMessage(this.aesCtrKey_, aesCtrHmacAeadKey.aesCtrKey_);
                this.hmacKey_ = (HmacKey) visitor.visitMessage(this.hmacKey_, aesCtrHmacAeadKey.hmacKey_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.version_ = codedInputStream.readUInt32();
                            } else if (readTag == 18) {
                                AesCtrKey.Builder builder = this.aesCtrKey_ != null ? (AesCtrKey.Builder) this.aesCtrKey_.toBuilder() : null;
                                AesCtrKey aesCtrKey = (AesCtrKey) codedInputStream.readMessage(AesCtrKey.parser(), extensionRegistryLite);
                                this.aesCtrKey_ = aesCtrKey;
                                if (builder != null) {
                                    builder.mergeFrom(aesCtrKey);
                                    this.aesCtrKey_ = (AesCtrKey) builder.buildPartial();
                                }
                            } else if (readTag == 26) {
                                HmacKey.Builder builder2 = this.hmacKey_ != null ? (HmacKey.Builder) this.hmacKey_.toBuilder() : null;
                                HmacKey hmacKey = (HmacKey) codedInputStream.readMessage(HmacKey.parser(), extensionRegistryLite);
                                this.hmacKey_ = hmacKey;
                                if (builder2 != null) {
                                    builder2.mergeFrom(hmacKey);
                                    this.hmacKey_ = (HmacKey) builder2.buildPartial();
                                }
                            } else if (!codedInputStream.skipField(readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw new RuntimeException(e.setUnfinishedMessage(this));
                    } catch (IOException e2) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (PARSER == null) {
                    synchronized (AesCtrHmacAeadKey.class) {
                        if (PARSER == null) {
                            PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        }
                    }
                }
                return PARSER;
            default:
                throw new UnsupportedOperationException();
        }
        return DEFAULT_INSTANCE;
    }

    static {
        AesCtrHmacAeadKey aesCtrHmacAeadKey = new AesCtrHmacAeadKey();
        DEFAULT_INSTANCE = aesCtrHmacAeadKey;
        aesCtrHmacAeadKey.makeImmutable();
    }

    public static AesCtrHmacAeadKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesCtrHmacAeadKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
