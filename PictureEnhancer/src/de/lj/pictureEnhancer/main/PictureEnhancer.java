package de.lj.pictureEnhancer.main;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.photo.Photo;

public class PictureEnhancer {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat src = Imgcodecs.imread("res/in.png");
		Mat denoised = new Mat(src.size(), src.type());
		Photo.fastNlMeansDenoisingColored(src, denoised, 10, 10, 5, 15);
		Imgcodecs.imwrite("res/out.png", denoised);
	}
}
