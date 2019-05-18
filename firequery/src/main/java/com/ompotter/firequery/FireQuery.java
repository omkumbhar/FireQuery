package com.ompotter.firequery;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class FireQuery {
    public CollectionReference colReference;

    public FireQuery(CollectionReference colReference) {
        this.colReference = colReference;
    }
    public Task<List<QuerySnapshot>> whereNotEqualTo(String field, int value) {
        Task task1 = this.colReference.whereLessThan(field, value).get();
        Task task2 = this.colReference.whereGreaterThan(field, value).get();
        return Tasks.whenAllSuccess(task1, task2);
    }
}
