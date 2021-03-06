package androidx.security.crypto;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.util.ArraySet;
import android.util.Pair;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadFactory;
import com.google.crypto.tink.aead.AeadKeyTemplates;
import com.google.crypto.tink.config.TinkConfig;
import com.google.crypto.tink.daead.DeterministicAeadFactory;
import com.google.crypto.tink.daead.DeterministicAeadKeyTemplates;
import com.google.crypto.tink.integration.android.AndroidKeysetManager.Builder;
import com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.subtle.Base64;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class EncryptedSharedPreferences implements SharedPreferences {
    private static final String KEY_KEYSET_ALIAS = "__androidx_security_crypto_encrypted_prefs_key_keyset__";
    private static final String NULL_VALUE = "__NULL__";
    private static final String VALUE_KEYSET_ALIAS = "__androidx_security_crypto_encrypted_prefs_value_keyset__";
    final String mFileName;
    final DeterministicAead mKeyDeterministicAead;
    final List<OnSharedPreferenceChangeListener> mListeners = new ArrayList();
    final String mMasterKeyAlias;
    final SharedPreferences mSharedPreferences;
    final Aead mValueAead;

    /* renamed from: androidx.security.crypto.EncryptedSharedPreferences$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$security$crypto$EncryptedSharedPreferences$EncryptedType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.security.crypto.EncryptedSharedPreferences$EncryptedType[] r0 = androidx.security.crypto.EncryptedSharedPreferences.EncryptedType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$security$crypto$EncryptedSharedPreferences$EncryptedType = r0
                androidx.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = androidx.security.crypto.EncryptedSharedPreferences.EncryptedType.STRING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$security$crypto$EncryptedSharedPreferences$EncryptedType     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = androidx.security.crypto.EncryptedSharedPreferences.EncryptedType.INT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$security$crypto$EncryptedSharedPreferences$EncryptedType     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = androidx.security.crypto.EncryptedSharedPreferences.EncryptedType.LONG     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$androidx$security$crypto$EncryptedSharedPreferences$EncryptedType     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = androidx.security.crypto.EncryptedSharedPreferences.EncryptedType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$androidx$security$crypto$EncryptedSharedPreferences$EncryptedType     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = androidx.security.crypto.EncryptedSharedPreferences.EncryptedType.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$androidx$security$crypto$EncryptedSharedPreferences$EncryptedType     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = androidx.security.crypto.EncryptedSharedPreferences.EncryptedType.STRING_SET     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.security.crypto.EncryptedSharedPreferences.AnonymousClass1.<clinit>():void");
        }
    }

    private static final class Editor implements android.content.SharedPreferences.Editor {
        private AtomicBoolean mClearRequested = new AtomicBoolean(false);
        private final android.content.SharedPreferences.Editor mEditor;
        private final EncryptedSharedPreferences mEncryptedSharedPreferences;
        private final List<String> mKeysChanged;

        Editor(EncryptedSharedPreferences encryptedSharedPreferences, android.content.SharedPreferences.Editor editor) {
            this.mEncryptedSharedPreferences = encryptedSharedPreferences;
            this.mEditor = editor;
            this.mKeysChanged = new CopyOnWriteArrayList();
        }

        public android.content.SharedPreferences.Editor putString(String str, String str2) {
            if (str2 == null) {
                str2 = EncryptedSharedPreferences.NULL_VALUE;
            }
            byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
            int length = bytes.length;
            ByteBuffer allocate = ByteBuffer.allocate(length + 8);
            allocate.putInt(EncryptedType.STRING.getId());
            allocate.putInt(length);
            allocate.put(bytes);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        public android.content.SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            if (set == null) {
                set = new ArraySet<>();
                set.add(EncryptedSharedPreferences.NULL_VALUE);
            }
            ArrayList<byte[]> arrayList = new ArrayList<>(set.size());
            int size = set.size() * 4;
            for (String bytes : set) {
                byte[] bytes2 = bytes.getBytes(StandardCharsets.UTF_8);
                arrayList.add(bytes2);
                size += bytes2.length;
            }
            ByteBuffer allocate = ByteBuffer.allocate(size + 4);
            allocate.putInt(EncryptedType.STRING_SET.getId());
            for (byte[] bArr : arrayList) {
                allocate.putInt(bArr.length);
                allocate.put(bArr);
            }
            putEncryptedObject(str, allocate.array());
            return this;
        }

        public android.content.SharedPreferences.Editor putInt(String str, int i) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(EncryptedType.INT.getId());
            allocate.putInt(i);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        public android.content.SharedPreferences.Editor putLong(String str, long j) {
            ByteBuffer allocate = ByteBuffer.allocate(12);
            allocate.putInt(EncryptedType.LONG.getId());
            allocate.putLong(j);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        public android.content.SharedPreferences.Editor putFloat(String str, float f) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(EncryptedType.FLOAT.getId());
            allocate.putFloat(f);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        public android.content.SharedPreferences.Editor putBoolean(String str, boolean z) {
            ByteBuffer allocate = ByteBuffer.allocate(5);
            allocate.putInt(EncryptedType.BOOLEAN.getId());
            allocate.put(z ? (byte) 1 : 0);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        public android.content.SharedPreferences.Editor remove(String str) {
            if (!this.mEncryptedSharedPreferences.isReservedKey(str)) {
                this.mEditor.remove(this.mEncryptedSharedPreferences.encryptKey(str));
                this.mKeysChanged.remove(str);
                return this;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" is a reserved key for the encryption keyset.");
            throw new SecurityException(sb.toString());
        }

        public android.content.SharedPreferences.Editor clear() {
            this.mClearRequested.set(true);
            return this;
        }

        public boolean commit() {
            if (this.mClearRequested.getAndSet(false)) {
                for (String str : this.mEncryptedSharedPreferences.getAll().keySet()) {
                    if (!this.mKeysChanged.contains(str) && !this.mEncryptedSharedPreferences.isReservedKey(str)) {
                        this.mEditor.remove(this.mEncryptedSharedPreferences.encryptKey(str));
                    }
                }
            }
            try {
                return this.mEditor.commit();
            } finally {
                notifyListeners();
                this.mKeysChanged.clear();
            }
        }

        public void apply() {
            this.mEditor.apply();
            notifyListeners();
        }

        private void putEncryptedObject(String str, byte[] bArr) {
            if (!this.mEncryptedSharedPreferences.isReservedKey(str)) {
                this.mKeysChanged.add(str);
                if (str == null) {
                    str = EncryptedSharedPreferences.NULL_VALUE;
                }
                try {
                    Pair encryptKeyValuePair = this.mEncryptedSharedPreferences.encryptKeyValuePair(str, bArr);
                    this.mEditor.putString((String) encryptKeyValuePair.first, (String) encryptKeyValuePair.second);
                } catch (GeneralSecurityException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Could not encrypt data: ");
                    sb.append(e.getMessage());
                    throw new SecurityException(sb.toString(), e);
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" is a reserved key for the encryption keyset.");
                throw new SecurityException(sb2.toString());
            }
        }

        private void notifyListeners() {
            for (OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : this.mEncryptedSharedPreferences.mListeners) {
                for (String onSharedPreferenceChanged : this.mKeysChanged) {
                    onSharedPreferenceChangeListener.onSharedPreferenceChanged(this.mEncryptedSharedPreferences, onSharedPreferenceChanged);
                }
            }
        }
    }

    private enum EncryptedType {
        STRING(0),
        STRING_SET(1),
        INT(2),
        LONG(3),
        FLOAT(4),
        BOOLEAN(5);
        
        private final int mId;

        private EncryptedType(int i) {
            this.mId = i;
        }

        public int getId() {
            return this.mId;
        }

        public static EncryptedType fromId(int i) {
            if (i == 0) {
                return STRING;
            }
            if (i == 1) {
                return STRING_SET;
            }
            if (i == 2) {
                return INT;
            }
            if (i == 3) {
                return LONG;
            }
            if (i == 4) {
                return FLOAT;
            }
            if (i != 5) {
                return null;
            }
            return BOOLEAN;
        }
    }

    public enum PrefKeyEncryptionScheme {
        AES256_SIV(DeterministicAeadKeyTemplates.AES256_SIV);
        
        private final KeyTemplate mDeterministicAeadKeyTemplate;

        private PrefKeyEncryptionScheme(KeyTemplate keyTemplate) {
            this.mDeterministicAeadKeyTemplate = keyTemplate;
        }

        /* access modifiers changed from: 0000 */
        public KeyTemplate getKeyTemplate() {
            return this.mDeterministicAeadKeyTemplate;
        }
    }

    public enum PrefValueEncryptionScheme {
        AES256_GCM(AeadKeyTemplates.AES256_GCM);
        
        private final KeyTemplate mAeadKeyTemplate;

        private PrefValueEncryptionScheme(KeyTemplate keyTemplate) {
            this.mAeadKeyTemplate = keyTemplate;
        }

        /* access modifiers changed from: 0000 */
        public KeyTemplate getKeyTemplate() {
            return this.mAeadKeyTemplate;
        }
    }

    EncryptedSharedPreferences(String str, String str2, SharedPreferences sharedPreferences, Aead aead, DeterministicAead deterministicAead) {
        this.mFileName = str;
        this.mSharedPreferences = sharedPreferences;
        this.mMasterKeyAlias = str2;
        this.mValueAead = aead;
        this.mKeyDeterministicAead = deterministicAead;
    }

    public static SharedPreferences create(String str, String str2, Context context, PrefKeyEncryptionScheme prefKeyEncryptionScheme, PrefValueEncryptionScheme prefValueEncryptionScheme) throws GeneralSecurityException, IOException {
        TinkConfig.register();
        Builder withSharedPref = new Builder().withKeyTemplate(prefKeyEncryptionScheme.getKeyTemplate()).withSharedPref(context, KEY_KEYSET_ALIAS, str);
        StringBuilder sb = new StringBuilder();
        String str3 = AndroidKeystoreKmsClient.PREFIX;
        sb.append(str3);
        sb.append(str2);
        KeysetHandle keysetHandle = withSharedPref.withMasterKeyUri(sb.toString()).build().getKeysetHandle();
        Builder withSharedPref2 = new Builder().withKeyTemplate(prefValueEncryptionScheme.getKeyTemplate()).withSharedPref(context, VALUE_KEYSET_ALIAS, str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str3);
        sb2.append(str2);
        KeysetHandle keysetHandle2 = withSharedPref2.withMasterKeyUri(sb2.toString()).build().getKeysetHandle();
        DeterministicAead primitive = DeterministicAeadFactory.getPrimitive(keysetHandle);
        String str4 = str;
        String str5 = str2;
        EncryptedSharedPreferences encryptedSharedPreferences = new EncryptedSharedPreferences(str4, str5, context.getSharedPreferences(str, 0), AeadFactory.getPrimitive(keysetHandle2), primitive);
        return encryptedSharedPreferences;
    }

    public Map<String, ?> getAll() {
        HashMap hashMap = new HashMap();
        for (Entry entry : this.mSharedPreferences.getAll().entrySet()) {
            if (!isReservedKey((String) entry.getKey())) {
                String decryptKey = decryptKey((String) entry.getKey());
                hashMap.put(decryptKey, getDecryptedObject(decryptKey));
            }
        }
        return hashMap;
    }

    public String getString(String str, String str2) {
        Object decryptedObject = getDecryptedObject(str);
        return (decryptedObject == null || !(decryptedObject instanceof String)) ? str2 : (String) decryptedObject;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        Set set2;
        Object decryptedObject = getDecryptedObject(str);
        if (decryptedObject instanceof Set) {
            set2 = (Set) decryptedObject;
        } else {
            set2 = new ArraySet();
        }
        return set2.size() > 0 ? set2 : set;
    }

    public int getInt(String str, int i) {
        Object decryptedObject = getDecryptedObject(str);
        return (decryptedObject == null || !(decryptedObject instanceof Integer)) ? i : ((Integer) decryptedObject).intValue();
    }

    public long getLong(String str, long j) {
        Object decryptedObject = getDecryptedObject(str);
        return (decryptedObject == null || !(decryptedObject instanceof Long)) ? j : ((Long) decryptedObject).longValue();
    }

    public float getFloat(String str, float f) {
        Object decryptedObject = getDecryptedObject(str);
        return (decryptedObject == null || !(decryptedObject instanceof Float)) ? f : ((Float) decryptedObject).floatValue();
    }

    public boolean getBoolean(String str, boolean z) {
        Object decryptedObject = getDecryptedObject(str);
        return (decryptedObject == null || !(decryptedObject instanceof Boolean)) ? z : ((Boolean) decryptedObject).booleanValue();
    }

    public boolean contains(String str) {
        if (!isReservedKey(str)) {
            return this.mSharedPreferences.contains(encryptKey(str));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" is a reserved key for the encryption keyset.");
        throw new SecurityException(sb.toString());
    }

    public android.content.SharedPreferences.Editor edit() {
        return new Editor(this, this.mSharedPreferences.edit());
    }

    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mListeners.add(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mListeners.remove(onSharedPreferenceChangeListener);
    }

    private Object getDecryptedObject(String str) {
        if (!isReservedKey(str)) {
            String str2 = NULL_VALUE;
            if (str == null) {
                str = str2;
            }
            try {
                String encryptKey = encryptKey(str);
                String string = this.mSharedPreferences.getString(encryptKey, null);
                if (string == null) {
                    return null;
                }
                boolean z = false;
                ByteBuffer wrap = ByteBuffer.wrap(this.mValueAead.decrypt(Base64.decode(string, 0), encryptKey.getBytes(StandardCharsets.UTF_8)));
                wrap.position(0);
                switch (AnonymousClass1.$SwitchMap$androidx$security$crypto$EncryptedSharedPreferences$EncryptedType[EncryptedType.fromId(wrap.getInt()).ordinal()]) {
                    case 1:
                        int i = wrap.getInt();
                        ByteBuffer slice = wrap.slice();
                        wrap.limit(i);
                        String charBuffer = StandardCharsets.UTF_8.decode(slice).toString();
                        if (charBuffer.equals(str2)) {
                            return null;
                        }
                        return charBuffer;
                    case 2:
                        return Integer.valueOf(wrap.getInt());
                    case 3:
                        return Long.valueOf(wrap.getLong());
                    case 4:
                        return Float.valueOf(wrap.getFloat());
                    case 5:
                        if (wrap.get() != 0) {
                            z = true;
                        }
                        return Boolean.valueOf(z);
                    case 6:
                        ArraySet arraySet = new ArraySet();
                        while (wrap.hasRemaining()) {
                            int i2 = wrap.getInt();
                            ByteBuffer slice2 = wrap.slice();
                            slice2.limit(i2);
                            wrap.position(wrap.position() + i2);
                            arraySet.add(StandardCharsets.UTF_8.decode(slice2).toString());
                        }
                        if (arraySet.size() != 1 || !str2.equals(arraySet.valueAt(0))) {
                            return arraySet;
                        }
                        return null;
                    default:
                        return null;
                }
            } catch (GeneralSecurityException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not decrypt value. ");
                sb.append(e.getMessage());
                throw new SecurityException(sb.toString(), e);
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(" is a reserved key for the encryption keyset.");
            throw new SecurityException(sb2.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public String encryptKey(String str) {
        if (str == null) {
            str = NULL_VALUE;
        }
        try {
            return Base64.encode(this.mKeyDeterministicAead.encryptDeterministically(str.getBytes(StandardCharsets.UTF_8), this.mFileName.getBytes()));
        } catch (GeneralSecurityException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not encrypt key. ");
            sb.append(e.getMessage());
            throw new SecurityException(sb.toString(), e);
        }
    }

    /* access modifiers changed from: 0000 */
    public String decryptKey(String str) {
        try {
            String str2 = new String(this.mKeyDeterministicAead.decryptDeterministically(Base64.decode(str, 0), this.mFileName.getBytes()), StandardCharsets.UTF_8);
            if (str2.equals(NULL_VALUE)) {
                return null;
            }
            return str2;
        } catch (GeneralSecurityException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not decrypt key. ");
            sb.append(e.getMessage());
            throw new SecurityException(sb.toString(), e);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isReservedKey(String str) {
        return KEY_KEYSET_ALIAS.equals(str) || VALUE_KEYSET_ALIAS.equals(str);
    }

    /* access modifiers changed from: 0000 */
    public Pair<String, String> encryptKeyValuePair(String str, byte[] bArr) throws GeneralSecurityException {
        String encryptKey = encryptKey(str);
        return new Pair<>(encryptKey, Base64.encode(this.mValueAead.encrypt(bArr, encryptKey.getBytes(StandardCharsets.UTF_8))));
    }
}
