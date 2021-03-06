/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.model.dataformat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.camel.CamelContext;
import org.apache.camel.model.DataFormatDefinition;
import org.apache.camel.spi.DataFormat;
import org.apache.camel.spi.Label;

/**
 * Represents a avro DataFormat {@link org.apache.camel.spi.DataFormat}
 *
 * @version 
 */
@Label("dataformat,transformation")
@XmlRootElement(name = "avro")
@XmlAccessorType(XmlAccessType.FIELD)
public class AvroDataFormat extends DataFormatDefinition {
    @XmlAttribute
    private String instanceClassName;
    @XmlTransient
    private Object schema;

    public AvroDataFormat() {
        super("avro");
    }

    public AvroDataFormat(String instanceClassName) {
        this();
        setInstanceClassName(instanceClassName);
    }

    public String getInstanceClassName() {
        return instanceClassName;
    }

    public void setInstanceClassName(String instanceClassName) {
        this.instanceClassName = instanceClassName;
    }

    public Object getSchema() {
        return schema;
    }

    public void setSchema(Object schema) {
        this.schema = schema;
    }

    @Override
    protected void configureDataFormat(DataFormat dataFormat, CamelContext camelContext) {
        if (this.instanceClassName != null) {
            setProperty(camelContext, dataFormat, "instanceClass", instanceClassName);
        }
        if (this.schema != null) {
            setProperty(camelContext, dataFormat, "schema", schema);
        }
    }
}
