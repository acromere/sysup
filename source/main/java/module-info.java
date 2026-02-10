import com.acromere.sysup.UpdaterMod;
import com.acromere.xenon.Module;

module com.acromere.sysup {

	// Compile-time only
	requires static lombok;

	// Both compile-time and run-time
	requires com.acromere.xenon;
	requires com.opencsv;
	requires java.logging;
	requires java.management;
	requires com.jcraft.jsch;
	requires org.apache.commons.lang3;

	opens com.acromere.sysup;
	opens com.acromere.sysup.bundles;
	opens com.acromere.sysup.settings;

	exports com.acromere.sysup to com.acromere.xenon, com.acromere.zerra;

	provides Module with UpdaterMod;

}
