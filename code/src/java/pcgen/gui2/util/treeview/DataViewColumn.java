/*
 * DataViewColumn.java
 * Copyright 2008 (C) Connor Petty <mistercpp2000@gmail.com>
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 * 
 * Created on Feb 18, 2008, 3:39:57 PM
 */
package pcgen.gui2.util.treeview;

/**
 *
 * @author Connor Petty <mistercpp2000@gmail.com>
 */
public interface DataViewColumn
{

    public static enum Visibility
    {

        ALWAYS_VISIBLE,
        INITIALLY_VISIBLE,
        INITIALLY_INVISIBLE
    }

    public String getName();

    public Class<?> getDataClass();

    /**
     * 
     * @return the column's visibility in the JTreePan
     */
    public Visibility getVisibility();

    public boolean isEditable();

	public boolean shouldCache();
}
