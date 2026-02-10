package com.acromere.sysup;

import com.acromere.xenon.Module;
import com.acromere.xenon.ToolRegistration;
import com.acromere.zenna.icon.AcromereIcon;
import com.acromere.zenna.icon.PerformIcon;
import com.acromere.zenna.icon.SouthBranchIcon;
import lombok.CustomLog;
import lombok.Getter;

@CustomLog
public class UpdaterMod extends Module {

	public static final String STYLESHEET = "mod.css";

	private PerformStationsResourceType performStationsAssetType;

	@Getter
	private StationUpdateManager stationUpdateManager;

	public UpdaterMod() {
		super();
	}

	@Override
	public void startup() throws Exception {
		super.startup();
		registerIcon( "acromere", new AcromereIcon() );
		registerIcon( "perform", new PerformIcon() );
		registerIcon( "updater", new PerformIcon() );

		getProgram().getResourceManager().addScheme( new PerformScheme( getProgram() ) );

		// Register the asset type
		performStationsAssetType = new PerformStationsResourceType( this );
		registerAssetType( performStationsAssetType );

		// Register the updater tool
		ToolRegistration design2dEditorRegistration = new ToolRegistration( this, UpdaterTool.class );
		design2dEditorRegistration.setName( "Perform Station Updater Tool" );
		registerTool( performStationsAssetType, design2dEditorRegistration );

		stationUpdateManager = new StationUpdateManager( this ).start();
	}

	@Override
	public void shutdown() throws Exception {
		stationUpdateManager.stop();

		unregisterTool( performStationsAssetType, UpdaterTool.class );
		unregisterAssetType( performStationsAssetType );

		getProgram().getResourceManager().removeScheme( PerformScheme.ID );

		unregisterIcon( getCard().getArtifact(), new SouthBranchIcon() );
		super.shutdown();
	}

}
