/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import javax.ws.rs.*;
import java.util.List;

/**
 * Interface of JAX-RS IDVKey REST API server
 */
@Path("/services")
public interface ServiceAPI {
    @GET
    @Path("/")
    @Produces("application/json")
    @AuthenticateCustomer
    List<Service> getCustomerServiceList();

    /**
     * Request a user for his permission to link him to a customer service/website.
     *
     * @param serviceId   Website service id
     * @return URL to redirect user for him to perform authentication
     */
    @POST
    @Path("{serviceId}/links")
    @Produces("application/json")
    @Consumes("application/json")
    @AuthenticateCustomer
    OperationResult requestUserLink(@PathParam("serviceId") String serviceId, ServiceLinkRequest serviceLinkRequest);

    @GET
    @Path("{serviceId}/links/requests/{opId}")
    @AuthenticateCustomer
    String getUserLinkRequestState(@PathParam("serviceId") String serviceId, @PathParam("opId") String opId);

    @GET
    @Path("{serviceId}/links/ref/{userRef}")
    @AuthenticateCustomer
    @Produces("application/json")
    ServiceLink getLinkStateByRef(@PathParam("serviceId") String serviceId, @PathParam("userRef") String userRef);

    @DELETE
    @Path("{serviceId}/links/ref/{userRef}")
    @AuthenticateCustomer
    void unlinkUserFromCustomerService(@PathParam("serviceId") String serviceId, @PathParam("userRef") String userRef);
}
