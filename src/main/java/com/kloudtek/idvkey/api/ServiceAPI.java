/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
     * @param serviceLinkRequest Service link request
     * @return URL to redirect user for him to perform authentication
     */
    @POST
    @Path("{serviceId}/links")
    @Produces("application/json")
    @Consumes("application/json")
    @AuthenticateCustomer
    OperationResult requestUserLink(@PathParam("serviceId") String serviceId, @NotNull @Valid ServiceLinkRequest serviceLinkRequest);

    @GET
    @Path("{serviceId}/links/requests/{opId}")
    @AuthenticateCustomer
    @Produces("application/json")
    ServiceLinkRequestStatus getUserLinkRequestState(@PathParam("serviceId") String serviceId, @PathParam("opId") String opId);

    @GET
    @Path("{serviceId}/links/ref/{userRef}")
    @AuthenticateCustomer
    @Produces("application/json")
    ServiceLink getLinkStateByRef(@PathParam("serviceId") String serviceId, @PathParam("userRef") String userRef);

    @DELETE
    @Path("{serviceId}/links/ref/{userRef}")
    @AuthenticateCustomer
    void unlinkUserFromCustomerService(@PathParam("serviceId") String serviceId, @PathParam("userRef") String userRef);

    @POST
    @Path("{serviceId}/notifications/authentication")
    @AuthenticateCustomer
    @Produces("application/json")
    OperationResult requestAuthentication(@PathParam("serviceId") String serviceId, @NotNull @Valid AuthenticationRequest authenticationRequest);

    @POST
    @Path("{serviceId}/notifications/preidauthentication")
    @AuthenticateCustomer
    @Produces("application/json")
    OperationResult requestPreIdentifiedAuthentication(@PathParam("serviceId") String serviceId, @NotNull @Valid PreIdentifiedAuthenticationRequest authenticationRequest);

    @POST
    @Path("{serviceId}/notifications/approval")
    @AuthenticateCustomer
    @Consumes("application/json")
    @Produces("application/json")
    OperationResult requestApproval(@PathParam("serviceId") String serviceId, @NotNull @Valid ApprovalRequest req);

    @POST
    @Path("{serviceId}/notifications/generic")
    @AuthenticateCustomer
    @Consumes("application/json")
    @Produces("application/json")
    OperationResult sendGenericNotification(@PathParam("serviceId") String serviceId, @NotNull @Valid GenericNotificationRequest notificationRequest);
}
