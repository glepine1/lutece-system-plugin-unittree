/*
 * Copyright (c) 2002-2011, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.unittree.business.sector;

import fr.paris.lutece.plugins.unittree.service.UnitTreePlugin;
import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.portal.service.plugin.PluginService;
import fr.paris.lutece.portal.service.spring.SpringContextService;

import java.util.List;


/**
 *
 * SectorHome
 *
 */
public final class SectorHome
{
    private static final String BEAN_SECTOR_DAO = "unittree.sectorDAO";
    private static Plugin _plugin = PluginService.getPlugin( UnitTreePlugin.PLUGIN_NAME );
    private static ISectorDAO _dao = (ISectorDAO) SpringContextService.getBean( BEAN_SECTOR_DAO );

    private SectorHome(  )
    {
    }

    public static Sector findByPrimaryKey( int nIdSector )
    {
        return _dao.load( nIdSector, _plugin );
    }

    public static List<Sector> findAll(  )
    {
        return _dao.loadAll( _plugin );
    }

    public static List<Sector> findByIdUnit( int nIdUnit )
    {
        return _dao.loadByIdUnit( nIdUnit, _plugin );
    }

    public static void addSectorToUnit( int nIdUnit, int nIdSector )
    {
        _dao.addSectorToUnit( nIdUnit, nIdSector, _plugin );
    }

    public static boolean hasSector( int nIdUnit, int nIdSector )
    {
        return _dao.hasSector( nIdUnit, nIdSector, _plugin );
    }

    public static void removeSectorsFromUnit( int nIdUnit )
    {
        _dao.removeSectorsFromUnit( nIdUnit, _plugin );
    }
}
