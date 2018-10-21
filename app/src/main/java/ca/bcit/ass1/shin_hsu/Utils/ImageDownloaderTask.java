package ca.bcit.ass1.shin_hsu.Utils;//      NEW SOLUTION DOES NOT NEED imagedownloader task
//
// package ca.bcit.ass1.shin_hsu.Utils;
//
//import android.graphics.drawable.Drawable;
//import android.os.AsyncTask;
//import android.util.Log;
//import android.view.View;
//import android.widget.ImageView;
//
//import ca.bcit.ass1.shin_hsu.R;
//
//import java.io.InputStream;
//import java.lang.ref.WeakReference;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class ImageDownloaderTask extends AsyncTask<String, Void, Drawable> {
//    private final WeakReference<ImageView> imageViewReference;
//
//    public ImageDownloaderTask( ImageView imageView ) {
//        imageViewReference = new WeakReference<ImageView>( imageView );
//    }
//
//    @Override
//    protected Drawable doInBackground( String... params ) {
//        return downloadSVG( params[ 0 ] );
//    }
//
//    @Override
//    protected void onPostExecute( Drawable drawable ) {
//        if ( isCancelled() ) {
//            drawable = null;
//        }
//
//        if ( imageViewReference != null ) {
//            ImageView imageView = imageViewReference.get();
//            if ( imageView != null ) {
//                if ( drawable != null ) {
//                    imageView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
//                    imageView.setImageDrawable(drawable);
//                } else {
//                    Drawable placeholder = imageView.getContext().getResources().getDrawable( R.drawable.placeholder );
//                    imageView.setImageDrawable( placeholder );
//                }
//            }
//        }
//    }
//
//    private Drawable downloadSVG( String url ) {
//        HttpURLConnection urlConnection = null;
//        try {
//            URL uri = new URL( url );
//            urlConnection = (HttpURLConnection) uri.openConnection();
//            int statusCode = urlConnection.getResponseCode();
//            if ( statusCode != HttpURLConnection.HTTP_OK ) {
//                return null;
//            }
//
////            InputStream inputStream = urlConnection.getInputStream();
////            if ( inputStream != null ) {
////                SVG svg = SVGParser. getSVGFromInputStream(inputStream);
////                Drawable drawable = svg.createPictureDrawable();
////                return drawable;
////            }
//        } catch ( Exception e ) {
//            urlConnection.disconnect();
//            Log.w( "ImageDownloader", "Error downloading image from " + url );
//        } finally {
//            if ( urlConnection != null ) {
//                urlConnection.disconnect();
//            }
//        }
//        return null;
//    }
//}
