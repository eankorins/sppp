var findingsArray = [{"errortype":"CCE_RA_GUARDED_BY_VIOLATED","msg":"@GuardedBy annotation on field 'counts' violated","severity":"major","locations":[{"key":"0","lbl":null,"filen":"SimpleHistogram.java","line":"44","msg":"Problem location","classname":"Histogram2","name_attr":"counts","type_attr_field":"[I","tag":"field"},{"key":"1","lbl":"relevant_sync_read","filen":"SimpleHistogram.java","line":"79","msg":"Synchronized read","classname":"Histogram2","meth":"increment","offset":"6","desc":"(I)V","tag":"instruction"},{"key":"2","lbl":"relevant_sync_read","filen":"SimpleHistogram.java","line":"82","msg":"Synchronized read","classname":"Histogram2","meth":"getCount","offset":"3","desc":"(I)I","tag":"instruction"},{"key":"3","lbl":"relevant_syncmixed_read","filen":"SimpleHistogram.java","line":"90","msg":"Sometimes synchronized read","classname":"Histogram2","meth":"addAll","offset":"17","desc":"(LHistogram2;)V","tag":"instruction"},{"key":"4","lbl":"relevant_sync_write","filen":"SimpleHistogram.java","line":"79","msg":"Synchronized write","classname":"Histogram2","meth":"increment","offset":"9","desc":"(I)V","tag":"instruction"},{"key":"5","lbl":"relevant_sync_write","filen":"SimpleHistogram.java","line":"90","msg":"Synchronized write","classname":"Histogram2","meth":"addAll","offset":"23","desc":"(LHistogram2;)V","tag":"instruction"},{"key":"6","lbl":"guard_type","filen":"SimpleHistogram.java","classname":"Histogram2","tag":"class"}],"guards":[{"tag":"guardRelative","locationRef":"6","guardpath":[],"name":"Histogram2.this","intrinsic":"true","key":"0"},{"tag":"guardUnknown","name":"<unknown>","intrinsic":"true","key":"1"}],"accesses":[{"location_attr":"1","guard_ref":[{"key":"0","status_attr":"always"}]},{"location_attr":"2","guard_ref":[{"key":"0","status_attr":"always"}]},{"location_attr":"3","guard_ref":[{"key":"1","status_attr":"sometimes"},{"key":"0","status_attr":"sometimes"}]},{"location_attr":"4","guard_ref":[{"key":"0","status_attr":"always"}]},{"location_attr":"5","guard_ref":[{"key":"0","status_attr":"always"}]}]}];