package com.acromere.sysup;

import com.acromere.xenon.Xenon;
import com.acromere.xenon.resource.Resource;
import com.acromere.xenon.resource.exception.ResourceException;
import com.acromere.xenon.scheme.ProductScheme;

public class PerformScheme extends ProductScheme {

	public static final String ID = "perform";

	public PerformScheme( Xenon program ) {
		super( program, ID );
	}

	@Override
	public boolean exists( Resource resource ) {
		return resource.getUri().getSchemeSpecificPart().equals( "updater" );
	}

	@Override
	public boolean canLoad( Resource resource ) throws ResourceException {
		return true;
	}

}
