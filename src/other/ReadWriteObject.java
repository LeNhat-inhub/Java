package other;

import java.io.*;
import java.nio.file.Paths;

public class ReadWriteObject {

    public void  write(Object object, String relativeFilePath) {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try {
            // nếu file chưa lưu object nào thì ghi bình thường
            String filePath = Paths.get(relativeFilePath).toAbsolutePath().toString();

            if (!hasObject(filePath)) {
                fout = new FileOutputStream(filePath);
                oos = new ObjectOutputStream(fout);
            } else {
                fout = new FileOutputStream(filePath, true);
                oos = new ObjectOutputStream(fout) {
                    @Override
                    protected void writeStreamHeader() throws IOException {
                        reset();
                    }
                };
            }

            oos.writeObject(object);
            System.out.println("Xong!");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // đọc object từ file
    public void read(String filePath) {
        FileInputStream fis = null;
        ObjectInputStream inStream = null;
        try {
            fis = new FileInputStream(filePath);
            inStream = new ObjectInputStream(fis);
            Object s;
            int i = 0;
            while (true) {
                s = inStream.readObject();
                System.out.println(++i + ": " + s.toString());
            }
        } catch (ClassNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inStream != null) {
                try {
                    inStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    // kiểm tra file có object lưu vào hay chưa
    public boolean hasObject(String filePath) {
        FileInputStream fi;
        boolean check = true;
        try {
            fi = new FileInputStream(filePath);
            ObjectInputStream inStream = new ObjectInputStream(fi);
            if (inStream.readObject() == null) {
                check = false;
            }
            inStream.close();
        } catch (FileNotFoundException e) {
            check = false;
        } catch (IOException e) {
            check = false;
        } catch (ClassNotFoundException e) {
            check = false;
            e.printStackTrace();
        }
        return check;
    }
}
