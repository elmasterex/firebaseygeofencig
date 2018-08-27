package com.uteq.pushnotification;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.Log;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;

import java.util.List;

public class GeofenceRegistrationService extends IntentService {

    private static final String TAG = "GeoIntentService";

    public GeofenceRegistrationService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);
        EnviarNotificacion notificacion = new EnviarNotificacion();

        if (geofencingEvent.hasError()) {
            Log.d(TAG, "GeofencingEvent error " + geofencingEvent.getErrorCode());
        } else {
            int transaction = geofencingEvent.getGeofenceTransition();
            List<Geofence> geofences = geofencingEvent.getTriggeringGeofences();
            Geofence geofence = geofences.get(0);

            if (transaction == Geofence.GEOFENCE_TRANSITION_ENTER && geofence.getRequestId().equals("Empresariales")) {
                Log.d(TAG, "You are inside Stanford University");
                notificacion.construirmensaje("Geofencin y Firabase", Global.nombre + "Entrando a Empresariales ");
            }
            if (transaction == Geofence.GEOFENCE_TRANSITION_EXIT && geofence.getRequestId().equals("Empresariales")) {
                Log.d(TAG, "You are inside Stanford University");
                notificacion.construirmensaje("Geofencin y Firabase", Global.nombre + " Saliendo de Empresariales ");

            }

            if (transaction == Geofence.GEOFENCE_TRANSITION_ENTER && geofence.getRequestId().equals("FCI")) {
                Log.d(TAG, "You are inside Stanford University");
                notificacion.construirmensaje("Geofencin y Firabase", Global.nombre + " Entrando de la FCI ");
            }
            if (transaction == Geofence.GEOFENCE_TRANSITION_EXIT && geofence.getRequestId().equals("FCI")) {
                Log.d(TAG, "You are inside Stanford University");
                notificacion.construirmensaje("Geofencin y Firabase", Global.nombre + " Saliendo de la FCI ");
            }

            if (transaction == Geofence.GEOFENCE_TRANSITION_ENTER && geofence.getRequestId().equals("Agrarias")) {
                Log.d(TAG, "You are inside Stanford University");
                notificacion.construirmensaje("Geofencin y Firabase", Global.nombre + " Entrando a Agrarias ");
            }
            if (transaction == Geofence.GEOFENCE_TRANSITION_EXIT && geofence.getRequestId().equals("Agrarias")) {
                Log.d(TAG, "You are inside Stanford University");
                notificacion.construirmensaje("Geofencin y Firabase", Global.nombre + " Saliendo de Agrarias");
            }

            if (transaction == Geofence.GEOFENCE_TRANSITION_ENTER && geofence.getRequestId().equals("Ambientales")) {
                Log.d(TAG, "You are inside Stanford University");
                notificacion.construirmensaje("Geofencin y Firabase", Global.nombre + " Entrando a Ambientales ");
            }
            if (transaction == Geofence.GEOFENCE_TRANSITION_EXIT && geofence.getRequestId().equals("Ambientales")) {
                Log.d(TAG, "You are inside Stanford University");
                notificacion.construirmensaje("Geofencin y Firabase", Global.nombre + " Saliendo de Ambientales");
            }

            if (transaction == Geofence.GEOFENCE_TRANSITION_ENTER && geofence.getRequestId().equals(Constants.GEOFENCE_ID_STAN_UNI)) {
                Log.d(TAG, "You are inside Stanford University");
                notificacion.construirmensaje("Geofencin y Firabase", Global.nombre + " Entrando a Ingreatsol ");
            }
            if (transaction == Geofence.GEOFENCE_TRANSITION_EXIT && geofence.getRequestId().equals(Constants.GEOFENCE_ID_STAN_UNI)) {
                Log.d(TAG, "You are inside Stanford University");
                notificacion.construirmensaje("Geofencin y Firabase", Global.nombre + " Saliendo de Ingreatsol ");
            }

        }
    }
}