package com.acromere.sysup;

import com.acromere.xenon.XenonProgramProduct;
import com.acromere.xenon.resource.ResourceType;
import lombok.CustomLog;

@CustomLog
public class PerformStationsResourceType extends ResourceType {

	public static final String KEY = "updater";

	public PerformStationsResourceType( XenonProgramProduct product ) {
		super( product, KEY );
		setDefaultCodec( new PerformStationCodec( product ) );
	}

	@Override
	public String getKey() {
		return KEY;
	}

}
