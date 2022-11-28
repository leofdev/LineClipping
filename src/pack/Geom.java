package pack;

public class Geom {
	
    public static float[] rotate(float cx, float cy, float px, float py, float ang) { //World rotation
        float sin = (float) Math.sin(ang); float cos = (float) Math.cos(ang);
    	
        float a = px - cx; float b = py - cy;
        
        float xx = (+a * cos - b * sin + cx);
        float yy = (+a * sin + b * cos + cy);
        
        return new float[]{xx, yy};
    }
    
    public static float[] rotMov(float cx, float cy, float px, float py, float d) { //Movimentation

        float cos = (float) Math.cos(d); float sin = (float) Math.sin(d);
         
        float nx = (cos * (px - cx)) + (sin * (py - cy)) + cx;
        float ny = (cos * (py - cy)) - (sin * (px - cx)) + cy;
         
        return new float [] {nx, ny};
     }

}
