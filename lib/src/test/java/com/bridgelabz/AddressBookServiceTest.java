package com.bridgelabz;

import java.time.LocalDate;

import java.util.List;


import org.junit.Assert;
import org.junit.Test;

public class AddressBookServiceTest {

	 @Test
	    public void givenAddressBookDBWhenRetrivedShouldMatchPersonCount() {
	        AddressBookService addressBookService = new AddressBookService();
	        List<Person> addressBookDataList = addressBookService.readAddressBookData(AddressBookService.IOService.DB_IO);
	        Assert.assertEquals(3, addressBookDataList.size());
	    }

	    @Test
	    public void givenContactInformationWhenUpdatedShouldSyncWithDB() {
	        AddressBookService addressBookService = new AddressBookService();
	        List<Person> addressBookDataList = addressBookService.readAddressBookData(AddressBookService.IOService.DB_IO);
	        addressBookService.updateContactNumber("Maya", "9028363759");
	        boolean result = addressBookService.checkAddressBookInSyncWithDB("Maya");
	        Assert.assertTrue(result);
	    }

	    @Test
	    public void givenDateRangeWhenRetrieved_ShouldMatchEntryCount() {
	        AddressBookService addressBookService = new AddressBookService();
	        LocalDate startDate = LocalDate.of(2016, 01, 01);
	        LocalDate endDate = LocalDate.now();
	        List<Person> addressBookDataList =
	                addressBookService.readAddressBookForDateRange(AddressBookService
	                        .IOService.DB_IO, startDate, endDate);
	        Assert.assertEquals(3, addressBookDataList.size());
	    }
}