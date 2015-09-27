package application;

public class HydrogenProxy {
	static {
		if(is64BitVM()){
			System.loadLibrary("hp64");
		}else{
			System.loadLibrary("hp");
		}
	}
	
	HydrogenProxy(){
	}
	
	private native String initInterface(String[] values);
	
	public static boolean is64BitVM() { 
        String bits = System.getProperty("sun.arch.data.model", "?");
        if (bits.equals("64")) {
            return true;
        }
        if (bits.equals("?")) {
            return System.getProperty("java.vm.name")
                    .toLowerCase().indexOf("64") >= 0;

        }
        return false;
    }
}
